package com.edison.algorithm.leetcode;

import java.util.Arrays;

//零钱兑换322
public class LeetCode322 {


    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        LeetCode322 le = new LeetCode322();
        int res = le.coinChange(new int[]{1,2,5}, 11);
        System.out.println(res);
    }

}


