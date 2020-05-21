package com.edison.algorithm.core.thread;

/**
 * 描述:
 * 安全发布对象
 *
 * @author gengyongchang
 * @create 2020-05-15 10:33
 */
public class UnSafePublish {
    private  String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnSafePublish unsafePublish = new UnSafePublish();
        for (String i : unsafePublish.getStates()) {
            System.out.print(i + " ");
        }

        new Thread(() -> unsafePublish.getStates()[0] = "d").start();

        System.out.println();
        for (String i : unsafePublish.getStates()) {
            System.out.print(i + " ");
        }
    }
}