package com.edison.algorithm.leetcode;

//使用最小花费爬楼梯
public class LeetCode746 {

    public int minCostClimbingStairs(int[] costs) {
        int n = costs.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + costs[i - 1], dp[i - 2] + costs[i - 2]);

        }
        return dp[n];

    }

    public int minCostClimbingStairs2(int[] costs) {
        int n = costs.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + costs[i - 1], prev + costs[i - 2]);
            prev = curr;
            curr = next;

        }
        return curr;

    }

    public int minCostClimbingStairs3(int[] costs) {

        for (int i = 2; i < costs.length; i++) {
            costs[i] += Math.min(costs[i - 2], costs[i - 1]);
        }
        return Math.min(costs[costs.length - 1],costs[costs.length - 2]);

    }

    public static void main(String[] args) {
        LeetCode746 le = new LeetCode746();
        System.out.println(le.minCostClimbingStairs3(new int[]{10,15,20}));
        System.out.println(le.minCostClimbingStairs3(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
