package com.edison.algorithm.leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 *
 * @Description TODO
 * @Date 2020/7/2下午11:40
 * @Created by edsiongeng
 */
public class LeetCode72 {

    public static int optimizeUniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[] dp = new int[n];
        //init
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        //formula:dp[i]=dp[i-1]+dp[i];
        for (int i = 1; i < m; i++) {
            //第i行0列第初始值
            dp[0] = 1;
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }

        }
        return dp[n - 1];
    }


    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;

        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n2; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <n1; i++) {
            dp[i][0] =i;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                //如果word1[i]与word2[j]相等，第i个字符对应下标是i-1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }

            }
        }
        return dp[n1][n2];
    }

    public static int optimizeMinDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[] dp = new int[n2 + 1];
        //dp[0...n2] init value
        for (int i = 0; i <= n2; i++) {
            dp[i] = i;
        }
        //formula:dp[j]=min(dp[j-1],pre,dp[j])+1

        for (int i = 1; i <= n1; i++) {
            int temp = dp[0];
            //init
            dp[0] = i;
            for (int j = 0; j <= n2; j++) {
                //pre相当于之前的dp[i-1][j-1]
                int pre = temp;
                temp = dp[j];
                //如果word[i]与word[j]  相等，第i个字符对应下标是i-1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = pre;
                } else {
                    dp[j] = Math.min(Math.min(dp[j - 1], pre), dp[j]) + 1;
                }
            }
        }
        return dp[n2];
    }
}
