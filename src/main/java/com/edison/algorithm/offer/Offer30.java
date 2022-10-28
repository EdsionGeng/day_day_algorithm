package com.edison.algorithm.offer;

import java.util.Stack;

//包含min函数的栈
public class Offer30 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Offer30() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);

    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
