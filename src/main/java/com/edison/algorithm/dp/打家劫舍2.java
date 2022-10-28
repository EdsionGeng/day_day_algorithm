package com.edison.algorithm.dp;

public class 打家劫舍2 {

    public int rob(int[] nums) {
        return Math.max(as(nums, 0, nums.length - 2), as(nums, 1, nums.length - 1));

    }

    public int as(int[] nums, int l, int r) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[l];
        dp[l + 1] = Math.max(nums[l], nums[l + 1]);
        for (int i = l + 2; i <= r; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[r];
    }
}
