package com.edison.algorithm.core.thread;

/**
 * 描述:
 * 对象逸出
 *
 * @author gengyongchang
 * @create 2020-05-15 10:42
 */
public class Escape {
    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            System.out.println(Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
         new Escape();


    }
}