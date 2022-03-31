package com.edison.algorithm.leetcode;

import java.util.Stack;

/**
 * 描述:
 * 基本计算器
 *
 * @author gengyc
 * @create 2022-03-16 17:36
 */
public class LeetCode224 {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1, res = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int cur = ch - '0';
                while (i + 1 < length && Character.isDigit(s.charAt(i + 1))) {
                    cur = s.charAt(++i) - '0' + cur * 10;
                }
                res = res + sign * cur;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            } else if (ch == ')') {
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }
}