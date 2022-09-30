package com.edison.algorithm.offer;

import java.util.Stack;

//两个栈实现一个队列
public class Offer09 {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public Offer09() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return -1;
            }
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public static void main(String[] args) {

    }
}
