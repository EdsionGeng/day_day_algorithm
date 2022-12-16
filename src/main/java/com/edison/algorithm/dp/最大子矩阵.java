package com.edison.algorithm.dp;

import java.util.Arrays;

public class 最大子矩阵 {

    public static int[] getMaxMatrix(int[][] matrix) {
        int[] ans = new int[4];
        int leftX = 0, leftY = 0;
        int sum = 0, maxSum = Integer.MIN_VALUE;
        int n = matrix.length, m = matrix[0].length;
        int[] dp = new int[m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp, 0);
            for (int j = i; j < n; j++) {
                sum = 0;
                for (int w = 0; w < m; w++) {
                    dp[w] += matrix[j][w];
                    if (sum > 0) {
                        sum += dp[w];
                    } else {
                        sum = dp[w];
                        leftX = i;
                        leftY = w;
                    }
                    if (sum > maxSum) {
                        maxSum = sum;
                        ans[0] = leftX;
                        ans[1] = leftY;
                        ans[2] = j;
                        ans[3] = w;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] matrix = getMaxMatrix(new int[][]{{1, 2}, {3, 4}});
        for (int i : matrix) {
            System.out.println(i);
        }
    }
}
