package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 不同路径
 *
 * @author gengyc
 * @create 2022-01-15 11:02
 */
public class LeetCode62 {
    //例如，上图是一个7 x 3 的网格。有多少可能的路径？
//
//说明：m 和 n 的值均不超过 100。
//
//示例 1:
//
//输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//
//向右 -> 向右 -> 向下
//向右 -> 向下 -> 向右
//向下 -> 向右 -> 向右
//示例 2:
//输入: m = 7, n = 3
//输出: 28
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][m - 1];
    }
}