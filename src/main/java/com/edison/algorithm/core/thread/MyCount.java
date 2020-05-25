package com.edison.algorithm.core.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description TODO
 * @Date 2020/4/22下午11:28
 * @Created by edsiongeng
 */
public class MyCount {
    private String oid;
    private int cash;
    private Lock lock = new ReentrantLock();
    private Condition save = lock.newCondition();
    private Condition draw = lock.newCondition();

    MyCount(String oid, int cash) {
        this.oid = oid;
        this.cash = cash;
    }

    public void saving(int x, String name) {
        lock.lock();
        if (x > 0) {
            cash += x;
            System.out.println(name + "存款" + x + ",当前余额为：" + cash);
        }
        draw.signalAll();
        lock.unlock();
    }

    public void drawing(int x, String name) {
        lock.lock();
        try {
            if (cash - x < 0) {
                draw.await();
            } else {
                cash -= x;
                System.out.println(name + "取款" + x + "，当前余额为" + cash);
            }
            save.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
