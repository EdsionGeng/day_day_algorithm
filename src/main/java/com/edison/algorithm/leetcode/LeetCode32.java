package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 最长有效括号
 *
 * @author gengyc
 * @create 2022-01-05 11:22
 */
public class LeetCode32 {
    /**
     * 给定一个只包含 ‘(’ 和 ‘)’ 的字符串，找出最长的包含有效括号的子串的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: “(()”
     * 输出: 2
     * 解释: 最长有效括号子串为 “()”
     * 示例 2:
     * <p>
     * 输入: “)()())”
     * 输出: 4
     * 解释: 最长有效括号子串为 “()()”
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
     */

    public static int longestValidParenthese(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chas = s.toCharArray();
        int[] dp = new int[chas.length];
        int pre = 0, res = 0;
        for (int i = 1; i < chas.length; i++) {
            if (chas[i] == ')') {
                pre = i - 1 - dp[i - 1];
                if (pre >= 0 && chas[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            if (dp[i] > res) {
                res = dp[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParenthese("(()())"));
    }
}