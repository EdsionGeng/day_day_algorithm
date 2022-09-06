package com.edison.algorithm.leetcode;

/**
 * 矩阵中最长递增路径
 */
public class LeetCode329 {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, loop(matrix, Integer.MIN_VALUE, dp, i, j));
            }
        }
        return max;
    }

    private int loop(int[][] mat, int pre, int[][] dp, int i, int j) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] <= pre) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int max = 0;
        max = Math.max(max, loop(mat, mat[i][j], dp, i - 1, j));
        max = Math.max(max, loop(mat, mat[i][j], dp, i + 1, j));
        max = Math.max(max, loop(mat, mat[i][j], dp, i, j - 1));
        max = Math.max(max, loop(mat, mat[i][j], dp, i, j + 1));
        dp[i][j] = max + 1;
        return dp[i][j];
    }
}
