package com.edison.algorithm.dp;

import java.util.Arrays;

public class 合并石头最低成本 {


    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;
        int MAX = Integer.MAX_VALUE / 2;
        int[] sum = new int[n + 1];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stones[i];
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], MAX);
            dp[i][i] = 0;
        }


        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int m = i; m < j; m += k - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }
                if ((j - i) % (k - 1) == 0) {
                    dp[i][j] += sum[j + 1] - sum[i];
                }
            }
        }

        return dp[0][n - 1];
    }
}
