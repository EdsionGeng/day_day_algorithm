package com.edison.algorithm.struct;

import java.util.Stack;

/**
 * 描述:
 * 使用栈实现队列
 *
 * @author gengyongchang
 * @create 2019-12-14 15:33
 */
public class UseStackImplQueue {

    private Stack<Integer> stack1;

    private Stack<Integer> stack2;

    private int count;


    public UseStackImplQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
        this.count = 0;
    }

    public void enqueue(int num) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(num);
        count++;
    }

    public int dequeue() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int num = stack2.pop();
        count--;
        return num;
    }


    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) {
        UseStackImplQueue stack = new UseStackImplQueue();
        stack.enqueue(1);
        stack.enqueue(2);
        stack.enqueue(3);
        stack.enqueue(4);

        System.out.println(stack.dequeue());

    }
}