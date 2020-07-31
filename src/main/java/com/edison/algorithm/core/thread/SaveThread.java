package com.edison.algorithm.core.thread;

/**
 * @Description TODO
 * @Date 2020/4/22下午11:25
 * @Created by edsiongeng
 */
public class SaveThread extends Thread {
    private String name;                //操作人
    private MyCount myCount;        //账户
    private int x;                            //存款金额

    SaveThread(String name, MyCount myCount, int x) {
        this.name = name;
        this.myCount = myCount;
        this.x = x;
    }

    @Override
    public void run() {
        myCount.saving(x, name);
    }
}
