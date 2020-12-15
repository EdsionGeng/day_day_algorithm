package com.edison.algorithm.dp;

import java.util.List;

/**
 * @Description TODO
 * @Date 2020/4/26上午12:51
 * @Created by edsiongeng
 */
public class DP {
    public int miniumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        List<Integer> lastRow = triangle.get(n - 1);

        for (int i = 0; i < n; ++i) {
            dp[n - 1][i] = lastRow.get(i);
        }

        for (int i = n - 2; i >= 0; --i) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < i + 1; ++j) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + row.get(j);
            }
        }
        return dp[0][0];
    }


    public static int climbStairs(int n) {
        if (n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
