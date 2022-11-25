package com.edison.algorithm.leetcode;

import java.util.Stack;

//单调栈 每日温度
public class LeetCode739 {

    public int[] dailyTemperature(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()) {
                int preIndex = stack.peek();
                if (temperatures[i] <= temperatures[preIndex]) {
                    break;
                }
                stack.pop();
                ans[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode739 le = new LeetCode739();
        System.out.println(le.dailyTemperature(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }
}
