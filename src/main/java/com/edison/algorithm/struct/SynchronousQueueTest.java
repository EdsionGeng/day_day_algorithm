package com.edison.algorithm.struct;

import java.util.concurrent.SynchronousQueue;

/**
 * 描述:
 * 阻塞队列测试
 *
 * @author gengyongchang
 * @create 2019-12-07 14:40
 */
public class SynchronousQueueTest {

    public static void main(String[] args) throws InterruptedException {

//              //true 为公平队列 false为非公平队列 默认为false
//        final SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
//
//        new Thread(() -> {
//            System.out.println("t1 begin");
//            try {
//                synchronousQueue.put("abc");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("t1 end");
//        }).start();
//
//        Thread.sleep(1000);
//        new Thread(() -> {
//            System.out.println("t2 begin");
//            try {
//                System.out.println(synchronousQueue.take());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("t2 end");
//        }).start();
        unfairQueueTest();
    }

    public static void unfairQueueTest() throws InterruptedException {
        final SynchronousQueue<String> queue = new SynchronousQueue<>(true);
        for (int i = 0; i < 10; i += 2) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " begin ...");
                try {
                    queue.put("put: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end...");
            }, "t" + i).start();


        }
        Thread.sleep(4000);
        for (int i = 1; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " begin ...");
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " end...");
            }, "t" + i).start();
        }
    }

}