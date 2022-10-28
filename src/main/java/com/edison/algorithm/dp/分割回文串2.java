package com.edison.algorithm.dp;

public class 分割回文串2 {

    public int minCut(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        if (n <= 1) return 0;
        int[] dp = new int[n];
        dp[1] = str[0] == str[1] ? 0 : 1;
        boolean[][] hw = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            hw[i][i] = true;
        }
        for (int i = 2; i < n; i++) {
            int index = i - 1;
            dp[i] = dp[i - 1] + 1;
            for (int j = 1; j <= index; j++) {
                if (hw[j][index] && str[j - 1] == str[i]) {
                    hw[j - 1][i] = true;
                    dp[i] = Math.min(dp[i], j - 2 >= 0 ? dp[j - 2] + 1 : 0);

                }
            }
            if (str[i] == str[i - 1]) {
                hw[i - 1][i] = true;
                dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            }

        }
        return dp[n - 1];

    }


}
