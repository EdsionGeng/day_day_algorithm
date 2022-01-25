package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 交错字符串
 *
 * @author gengyc
 * @create 2022-01-21 16:55
 */
public class LeetCode97 {
    //给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
//
//示例 1:
//
//输入: s1 = “aabcc”, s2 = “dbbca”, s3 = “aadbbcbcac”
//输出: true
//示例 2:
//
//输入: s1 = “aabcc”, s2 = “dbbca”, s3 = “aadbbbaccc”
//输出: false
    public boolean isInternalLeave(String s1, String s2, String s3) {
        if ((s1.length() + s2.length()) != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            dp[0][i] = dp[0][i - 1] && s1.charAt(i - 1) == s3.charAt(i - 1) ? true : false;
        }
        for (int i = 1; i < s2.length(); i++) {
            dp[i][0] = dp[i - 1][0] && s2.charAt(i - 1) == s3.charAt(i - 1) ? true : false;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = (dp[i][j - 1] && s1.charAt(j - 1) == s3.charAt(i + j - 1)) || (dp[i - 1][j] && s2.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s2.length()][s1.length()];
    }
}