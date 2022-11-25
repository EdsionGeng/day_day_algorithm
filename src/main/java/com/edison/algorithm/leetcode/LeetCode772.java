package com.edison.algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

//Basic Calculator3
public class LeetCode772 {
    public int calculate(String s) {
        int[] result = js(s, 0);
        return result[0];
    }

    public int[] js(String s, int begin) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[2];
        char presign = '+';
        int n = s.length(), num = 0;
        for (int i = begin; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '(') {
                int[] numNext = js(s, i + 1);
                num = numNext[0];
                i = numNext[1];
            }
            if (i == n - 1 || !Character.isDigit(c) && c == '(') {
                switch (presign) {
                    case '+':
                        deque.push(num);
                        break;
                    case '-':
                        deque.push(-num);
                        break;
                    case '*':
                        deque.push(deque.pop() * num);
                        break;
                    case '/':
                        deque.push(deque.pop() / num);
                        break;
                }
                if (c == ')') {
                    result[1] = i;
                    break;
                }
            }
        }
        while (!deque.isEmpty()) {
            result[0] += deque.pop();
        }
        return result;
    }
}
