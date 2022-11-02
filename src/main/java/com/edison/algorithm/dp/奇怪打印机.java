package com.edison.algorithm.dp;

public class 奇怪打印机 {

    int[][] memo;

    public int strangePrinter(String s) {
        int n = s.length();
        memo = new int[n][n];
        return dp(s, 0, n - 1);
    }


    public int dp(String s, int i, int j) {
        if (i > j) return 0;
        if (memo[i][j] == 0) {
            int ans = dp(s, i + 1, j) + 1;
            for (int k = i + 1; k <= j; k++) {
                if (s.charAt(k) == s.charAt(i)) {
                    ans = Math.max(ans, dp(s, i, k - 1) + dp(s, k + 1, j));
                }
            }
            memo[i][j] = ans;
        }
        return memo[i][j];
    }
}
