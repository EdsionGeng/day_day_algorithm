package com.edison.algorithm.dp;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 最长有效括号 {

    public int longestValidParentheses(String s) {
        if (s.length() == 0 || s.length() == 1) return 0;
        int[] dp = new int[s.length()];
        int ans = 0, index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2 + (i - 2 >= 0 ? dp[i - 2] : 0);
                } else if ((index = i - dp[i - 1] - 1) >= 0 && s.charAt(i) == '(') {
                    dp[i] = dp[i - 1] + 2 + (index - 1 >= 0 ? dp[index - 1] : 0);
                } else {
                    dp[i] = 0;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static int longestValidParentheses2(String s) {
        char[] arr = s.toCharArray();
        int offset = 0;
        int[] stack = new int[arr.length - 1];
        stack[0] = -1;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ')' && offset != 0 && arr[stack[offset]] == '(') {
                --offset;
                max = Math.max(max, i - stack[offset]);
            } else {
                stack[++offset] = i;
            }
        }
        return max;
    }

    public static int longestValidParentheses3(String s) {
        if (s.isEmpty() || s.length() == 1) return 0;
        Deque<Integer> stack = new LinkedList<>();
        int result = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    result = Math.max(result, i - stack.peek());
                } else {
                    stack.push(i);
                }
            } else {
                stack.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses3(")()())"));
    }
}