package com.edison.algorithm.leetcode;

import java.util.Stack;

/**
 * 描述:
 * 两个棧实现队列
 *
 * @author gengyc
 * @create 2022-03-25 16:02
 */
public class LeetCode232 {
    static class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MyQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();

        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }

    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

    }
}