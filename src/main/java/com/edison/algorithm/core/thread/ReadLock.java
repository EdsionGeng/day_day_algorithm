package com.edison.algorithm.core.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Description TODO
 * @Date 2021/2/25下午10:32
 * @Created by edsiongeng
 */
public class ReadLock implements Lock {
    private Sync sync;
    private static int count;

    public ReadLock(int count) {
        this.count = count;
        sync = new Sync(count);
    }

    private static class Sync extends AbstractQueuedSynchronizer {
        public Sync(int count) {
            setState(count);
        }

        protected boolean tryAcquire(int acquires) {
            int c = getState();
            if (c == 0) {
                return false;
            }
            if (compareAndSetState(c, c - acquires)) {
                return true;
            }
            return false;
        }

        protected boolean tryRelease(int arg) {
            int c = getState();
            if (c == count) {
                throw new IllegalMonitorStateException();
            }
            if (compareAndSetState(c, c + arg)) {
                return true;
            }
            return false;
        }

        public Condition newCondition() {
            return new ConditionObject();
        }
    }


    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
