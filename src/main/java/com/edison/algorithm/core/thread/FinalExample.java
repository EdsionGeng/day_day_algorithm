package com.edison.algorithm.core.thread;

/**
 * @Descriptin final变量内存模型
 * @Date 2020/3/8下午11:06
 * @Created by edsiongeng
 */
public class FinalExample {
    int i;
    final int j;
    static FinalExample obj;

    public FinalExample()

    {
        i = 1;
        j = 2;

    }

    public static void writer() {
        obj = new FinalExample();
    }

    public static void reader() {
        FinalExample object = obj;
//        int a = object.i;
//        System.out.println(a);
        int b = object.j;
        System.out.println(b);


    }

    public static void main(String[] args) {
        new Thread(() -> reader()).start();


        new Thread(() -> writer()).start();
    }
}
