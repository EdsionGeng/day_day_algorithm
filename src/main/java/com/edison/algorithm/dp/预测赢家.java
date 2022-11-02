package com.edison.algorithm.dp;

public class 预测赢家 {

    public static boolean predictTheWinner(int[] nums) {

        int length = nums.length;
        int[] dp = new int[length];

        for (int i = 0; i < length; i++) {
            dp[i] = nums[i];
        }

        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[length - 1] >= 0;

    }

    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{5,3,4,5}));
    }


}
