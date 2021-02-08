package com.edison.algorithm.core.asm;

import java.lang.management.ManagementFactory;

public class Base {
    public void process() {
        System.out.println("process");

    }
    public static void process1() {
        System.out.println("process");

    }
    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];
        System.out.println("pid:" + s);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            process1();
        }
    }
}
