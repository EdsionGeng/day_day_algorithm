package com.edison.algorithm.struct;

/**
 * @Description 栈
 * @Date 2020/2/29下午11:29
 * @Created by edsiongeng
 */
public class MyStack {
    private int[] array;
    private int maxSize;
    private int top;

    public MyStack(int size) {
        this.maxSize = size;
        array = new int[size];
        top = -1;

    }

    public void push(int value) {
        if (top < maxSize - 1) {
            array[++top] = value;
        }

    }

    public int pop() {
        return array[top--];
    }

    public int peek() {
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        while (!myStack.isEmpty()){
            System.out.println(myStack.pop());
        }
    }
}
