package com.edison.algorithm.leetcode;

import java.util.Stack;

/**
 * 描述:
 * 最小栈
 *
 * @author gengyc
 * @create 2022-02-23 11:32
 */
public class LeetCode155 {
    class MinStack {
        private int min = Integer.MAX_VALUE;
        private Stack<Integer> stack;

        public MinStack() {
            this.stack = new Stack<>();
        }

        public void push(int x) {
            if (min > x) {
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if (stack.pop() == min) {
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

}