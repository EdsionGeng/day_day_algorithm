package com.edison.algorithm.dp;

public class 删除与获得点数 {

    public static int deleteAndEarn(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] all = new int[max + 1];
        for (int i = 0; i < len; i++) {
            all[nums[i]]++;
        }
        int[] dp = new int[max + 1];
        dp[1] = all[1];
        for (int i = 2; i < max + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + all[i] * i);
        }
        return dp[max];
    }

    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
