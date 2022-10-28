package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 不同路径2
 *
 * @author gengyc
 * @create 2022-01-15 11:10
 */
public class LeetCode63 {
    //网格中的障碍物和空位置分别用 1 和 0 来表示。
//
//说明：m 和 n 的值均不超过 100。
//
//示例 1:
//
//输入:
//[
//[0,0,0],
//[0,1,0],
//[0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//
//向右 -> 向右 -> 向下 -> 向下
//向下 -> 向下 -> 向右 -> 向右
    public int uniquePaths(int[][] arr) {
        if (arr == null || arr.length <= 0) {
            return 0;
        }
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < cols; i++) {
            if (arr[0][i] == 1) {
                dp[0][i] = 0;
                break;
            } else {
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < rows; i++) {
            if (arr[i][0] == 1) {
                dp[i][0] = 0;
                break;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (arr[i][j] == 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        LeetCode63 le = new LeetCode63();
        System.out.println(le.uniquePaths(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

}