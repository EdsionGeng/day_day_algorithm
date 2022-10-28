package com.edison.algorithm.dp;

public class 块3n披萨 {

    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        if (n == 1) return slices[0];
        return Math.max(calculate(slices, 0, n - 2), calculate(slices, 1, n - 1));

    }

    public int calculate(int[] slices, int left, int right) {
        int size = (right - left) + 1;
        int choose = (size + 1) / 3;
        int[][] dp = new int[size + 1][choose + 1];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= choose; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], slices[i - 1 + left] + (i >= 2 ? dp[i - 2][j - 1] : 0));
            }
        }
        return dp[size][choose];

    }
}
