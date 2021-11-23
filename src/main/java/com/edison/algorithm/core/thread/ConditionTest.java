package com.edison.algorithm.core.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * @Description TODO
 * @Date 2020/4/22下午11:24
 * @Created by edsiongeng
 */
public class ConditionTest {
    public static void main(String[] args) throws Exception{
//        //创建并发访问的账户
//        MyCount myCount = new MyCount("95599200901215522", 10000);
//        //创建一个线程池
//        ExecutorService pool = Executors.newFixedThreadPool(2);
//        Thread t1 = new SaveThread("张三", myCount, 2000);
//        Thread t2 = new SaveThread("李四", myCount, 3600);
//        Thread t3 = new DrawThread("王五", myCount, 2700);
//        Thread t4 = new SaveThread("老张", myCount, 600);
//        Thread t5 = new DrawThread("老牛", myCount, 1300);
//        Thread t6 = new DrawThread("胖子", myCount, 800);
//        //执行各个线程
//        pool.execute(t1);
//        pool.execute(t2);
//        pool.execute(t3);
//        pool.execute(t4);
//        pool.execute(t5);
//        pool.execute(t6);
//        //关闭线程池
//        pool.shutdown();
//        ForkJoinPool forkJoinPool=ForkJoinPool.commonPool();
        final Object obj = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += i;
                }
                try {
                    synchronized (obj) {
                        obj.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(sum);
            }
        });
        A.start();
      //  Thread.sleep(1);
        synchronized (obj) {
            obj.notify();
        }
    }
}
