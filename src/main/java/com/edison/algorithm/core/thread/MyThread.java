package com.edison.algorithm.core.thread;

/**
 * 描述:
 *
 * @author gengyongchang
 * @create 2020-04-22 19:25
 */
public class MyThread extends Thread {
    private   User u;
    private   int y = 0;

    MyThread(String name, User u, int y) {
        super(name);
        this.u = u;
        this.y = y;
    }

    @Override
    public void run() {
        u.oper(y);
    }
}