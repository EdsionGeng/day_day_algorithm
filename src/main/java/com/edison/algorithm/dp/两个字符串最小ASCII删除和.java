package com.edison.algorithm.dp;

public class 两个字符串最小ASCII删除和 {

    public static int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char a = s1.charAt(i - 1);
            dp[i][0] = dp[i - 1][0] + a;
            for (int j = 1; j <= n; j++) {
                char b = s2.charAt(j - 1);
                dp[0][j] = dp[0][j - 1] + b;
                if (a == b) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1] + a), dp[i - 1][j] + b);
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + ((int) a + (int) (b)), dp[i][j - 1] + ((int) b)), dp[i - 1][j] + ((int) a));}

            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("delete","leet"));
    }
}
