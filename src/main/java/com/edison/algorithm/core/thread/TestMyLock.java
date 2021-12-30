package com.edison.algorithm.core.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Date 2021/2/25下午10:31
 * @Created by edsiongeng
 */
public class TestMyLock {
    public static List<String> list = new ArrayList<>();

    static WriteLock writeLock = new WriteLock();
    static ReadLock readLock = new ReadLock(4);

    static class Task implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                writeLock.lock();
                list.add(Thread.currentThread().getName() + "----" + i);
                writeLock.unlock();
            }

        }
    }

    static class Task2 implements Runnable {

        @Override
        public void run() {
            readLock.lock();
            System.out.println(Thread.currentThread().getName() + " 进入Lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            readLock.unlock();
            System.out.println(Thread.currentThread().getName() + "release lock!");

        }
    }

    public static void main(String[] args) throws Exception {
        List<Thread> list = new ArrayList<>();
//        Task task = new Task();
//        for (int i = 0; i < 100; i++) {
//            list.add(new Thread(task, "thread" + i));
//        }
        Task2 task2 = new Task2();
        for (int i = 0; i < 100; i++) {
            list.add(new Thread(task2, "thread" + i));
        }
        for (int i = 0; i < 100; i++) {
            list.get(i).start();
        }
        for (int i = 0; i < 100; i++) {
            list.get(i).join();
        }
        System.out.println(TestMyLock.list.size());
    }
}
