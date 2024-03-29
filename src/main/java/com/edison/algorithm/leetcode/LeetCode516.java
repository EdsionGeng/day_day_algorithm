package com.edison.algorithm.leetcode;

//最长回文子序列
public class LeetCode516 {
    public int longestPalindromeSubSeq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i +1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LeetCode516 le = new LeetCode516();
        System.out.println(le.longestPalindromeSubSeq("cbbbd"));
    }


}
