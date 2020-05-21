package com.edison.algorithm.core.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 *
 * @author gengyongchang
 * @create 2020-04-22 19:25
 */
public class User {
    private String code;
    private  int cash;
    private Lock lock = new ReentrantLock(true);

    User(String code, int cash) {
        this.code = code;
        this.cash = cash;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 业务方法
     *
     * @param x 添加x万元
     */
    public void oper(int x) {
        lock.lock();
        try {
            Thread.sleep(10L);
            this.cash += x;
            System.out.println(Thread.currentThread().getName() + "运行结束，增加“" + x + "”，当前用户账户余额为：" + cash);
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "code='" + code + '\'' +
                ", cash=" + cash +
                '}';
    }
}