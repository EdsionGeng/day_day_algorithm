package com.edison.algorithm.algorithm;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * @Description TODO
 * @Date 2020/3/1下午3:55
 * @Created by edsiongeng
 */
public class MyCharStack {
    private char[] array;
    private int maxSize;
    private int top;

    public MyCharStack(int size) {
        this.maxSize = size;
        array = new char[size];
        top = -1;
    }

    public void push(char value) {
        if (top < maxSize - 1) {
            array[++top] = value;
        }
    }

    public char pop() {
        return array[top--];
    }

    public char peek() {
        return array[top];
    }

    public char peekN(int n) {
        return array[n];
    }

    public void displayStack() {
        System.out.println("bottom-->top:");
        for (int i = 0; i < top + 1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName(
                "java.lang.Integer$IntegerCache");
        //获取cache成员变量
        Field field = clazz.getDeclaredField("cache");
        field.setAccessible(true);
        Integer[] cache = (Integer[]) field.get(clazz);

        // Rewrite the Integer cache
        for (int i = 0; i < cache.length; i++) {
            cache[i] = new Integer(i + 1);
        }
        Integer a = 1;
        Integer b = a + a;
        System.out.println(b);
    }
}
