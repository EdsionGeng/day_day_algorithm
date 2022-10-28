package com.edison.algorithm.dp;

public class 乘积最大子数组 {

    public static int maxProduct(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 0;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] * nums[i];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
    }
}
