package com.edison.algorithm.algorithm;

import lombok.Data;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/**
 * 描述:
 * 时间轮算法
 *
 * @author gengyc
 * @create 2022-02-24 17:52
 */
public class TimeWheel {
    private long tickMs;
    private int wheelSize;
    private long interval;
    private long currentTime;
    private TimerTaskList[] buckets;
    private volatile TimeWheel overflowWheel;
    private DelayQueue<TimerTaskList> delayQueue;

    public TimeWheel(long tickMs, int wheelSize, long currentTime, DelayQueue<TimerTaskList> delayQueue) {
        this.currentTime = currentTime;
        this.tickMs = tickMs;
        this.wheelSize = wheelSize;
        this.interval = tickMs * wheelSize;
        this.buckets = new TimerTaskList[wheelSize];
        this.currentTime = currentTime - (currentTime % tickMs);
        this.delayQueue = delayQueue;
        for (int i = 0; i < wheelSize; i++) {
            buckets[i] = new TimerTaskList();
        }
    }

    public boolean add(TimerTaskEntry entry) {
        long expiration = entry.getExpireMs();
        if (expiration < tickMs + currentTime) {
            return false;
        } else if (expiration < currentTime + interval) {
            long virtualId = (expiration / tickMs);
            int index = (int) (virtualId % wheelSize);
            TimerTaskList bucket = buckets[index];
            bucket.addTask(entry);
            if (bucket.setExpiration(virtualId * tickMs)) {
                delayQueue.offer(bucket);
                return true;
            }
        } else {
            TimeWheel timeWheel = getOverflowWheel();
            return timeWheel.add(entry);
        }
        return false;
    }

    private TimeWheel getOverflowWheel() {
        if (overflowWheel == null) {
            synchronized (this) {
                if (overflowWheel == null) {
                    overflowWheel = new TimeWheel(interval, wheelSize, currentTime, delayQueue);
                }
            }
        }
        return overflowWheel;
    }

    public void advanceLock(long timestamp) {
        if (timestamp > currentTime + tickMs) {
            currentTime = timestamp - (timestamp % tickMs);
        }
        if (overflowWheel != null) {
            this.getOverflowWheel().advanceLock(timestamp);
        }
    }

    public interface Timer {
        void advanceClock(long timeout);

        void add(TimerTask timerTask);

        int size();

        void shutdown();

    }

    class SystemTimer implements Timer {

        private TimeWheel timeWheel;
        private DelayQueue<TimerTaskList> delayQueue = new DelayQueue<>();
        private ExecutorService workerThreadPool;
        private ExecutorService bossThreadPool;

        public SystemTimer() {
            this.timeWheel = new TimeWheel(1, 20, System.currentTimeMillis(), delayQueue);
            this.workerThreadPool = Executors.newFixedThreadPool(100);
            this.bossThreadPool = Executors.newFixedThreadPool(1);
            this.bossThreadPool.submit(() -> {
                for (; ;
                ) {
                    this.advanceClock(10);
                }
            });
        }

        public void addTimerTaskEntry(TimerTaskEntry entry) {
            if (!timeWheel.add(entry)) {
                TimerTask timerTask = entry.getTimerTask();
                System.out.println("task is running ->" + timerTask.getDesc());
                workerThreadPool.submit(timerTask);
            }
        }

        @Override
        public void advanceClock(long timeout) {
            try {
                TimerTaskList bucket = delayQueue.poll(timeout, TimeUnit.MILLISECONDS);
                if (bucket != null) {
                    timeWheel.advanceLock(bucket.getExpiration());
                    bucket.clear(this::addTimerTaskEntry);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void add(TimerTask timerTask) {
            TimerTaskEntry entry = new TimerTaskEntry(timerTask, timerTask.getDelayMs() + System.currentTimeMillis());
            timerTask.setTimerTaskEntry(entry);
            addTimerTaskEntry(entry);
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public void shutdown() {
            this.bossThreadPool.shutdown();
            this.workerThreadPool.shutdown();
            this.timeWheel = null;

        }
    }

    class TimerTaskList implements Delayed {
        private TimerTaskEntry root = new TimerTaskEntry(null, -1);

        {
            root.next = root;
            root.prev = root;
        }

        private AtomicLong expiration = new AtomicLong(-1L);

        public long getExpiration() {
            return expiration.get();
        }

        boolean setExpiration(long expirationMs) {
            return expiration.getAndSet(expirationMs) != expirationMs;
        }

        public boolean addTask(TimerTaskEntry entry) {
            boolean done = false;
            while (!done) {
                entry.remove();
                synchronized (this) {
                    if (entry.timedTaskList == null) {
                        entry.timedTaskList = this;
                        TimerTaskEntry tail = root.prev;
                        entry.prev = tail;
                        entry.next = root;
                        tail.next = entry;
                        root.prev = entry;
                        done = true;
                    }
                }
            }
            return true;
        }

        public void remove(TimerTaskEntry entry) {
            synchronized (this) {
                if (entry.getTimedTaskList().equals(this)) {
                    entry.next.prev = entry.prev;
                    entry.prev.next = entry.next;
                    entry.next = null;
                    entry.prev = null;
                    entry.timedTaskList = null;
                }
            }
        }

        public synchronized void clear(Consumer<TimerTaskEntry> entryConsumer) {
            TimerTaskEntry head = root.next;
            while (!head.equals(root)) {
                remove(head);
                entryConsumer.accept(head);
                head = root.next;
            }
            expiration.set(-1L);
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return Math.max(0, unit.convert(expiration.get() - System.currentTimeMillis(), TimeUnit.MILLISECONDS));
        }

        @Override
        public int compareTo(Delayed o) {
            if (o instanceof TimerTaskList) {
                return Long.compare(expiration.get(), ((TimerTaskList) o).expiration.get());
            }
            return 0;
        }
    }

    @Data
    class TimerTaskEntry implements Comparable<TimerTaskEntry> {
        private TimerTask timerTask;
        private long expireMs;
        volatile TimerTaskList timedTaskList;
        TimerTaskEntry next;
        TimerTaskEntry prev;

        public TimerTaskEntry(TimerTask timerTask, long expireMs) {
            this.timerTask = timerTask;
            this.expireMs = expireMs;
            this.next = null;
            this.prev = null;
        }

        void remove() {
            TimerTaskList currentList = timedTaskList;
            while (currentList != null) {
                currentList.remove(this);
                currentList = timedTaskList;
            }
        }

        @Override
        public int compareTo(TimerTaskEntry o) {
            return (int) (this.expireMs - o.getExpireMs());
        }
    }

    @Data
    class TimerTask implements Runnable {
        private long delayMs;
        private TimerTaskEntry timerTaskEntry;
        private String desc;

        public TimerTask(String desc, long delayMs) {
            this.desc = desc;
            this.delayMs = delayMs;
            this.timerTaskEntry = null;
        }

        public synchronized void setTimerTaskEntry(TimerTaskEntry entry) {
            if (timerTaskEntry != null && timerTaskEntry != entry) {
                timerTaskEntry.remove();
            }
            timerTaskEntry = entry;
        }

        public TimerTaskEntry getTimerTaskEntry() {
            return timerTaskEntry;
        }

        @Override
        public void run() {
            System.out.println("task run" + desc);
        }
    }
}