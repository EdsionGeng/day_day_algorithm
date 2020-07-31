package com.edison.algorithm.core.thread;

/**
 * @Description TODO
 * @Date 2020/4/22下午11:26
 * @Created by edsiongeng
 */
public class DrawThread extends Thread {
    private String name;                //操作人
    private MyCount myCount;        //账户
    private int x;                            //存款金额

    DrawThread(String name, MyCount myCount, int x) {
        this.name = name;
        this.myCount = myCount;
        this.x = x;
    }

    @Override
    public void run() {
        myCount.drawing(x, name);
    }
}
