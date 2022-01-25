package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 解码方法
 *
 * @author gengyc
 * @create 2022-01-21 10:32
 */
public class LeetCode91 {
    //一条包含字母 A-Z 的消息通过以下方式进行了编码：
    //
    //‘A’ -> 1
    //‘B’ -> 2
    //…
    //‘Z’ -> 26
    //给定一个只包含数字的非空字符串，请计算解码方法的总数。
    //
    //示例 1:
    //
    //输入: “12”
    //输出: 2
    //解释: 它可以解码为 “AB”（1 2）或者 “L”（12）。
    //示例 2:
    //
    //输入: “226”
    //输出: 3
    //解释: 它可以解码为 “BZ” (2 26), “VF” (22 6), 或者 “BBF” (2 2 6) 。
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '0' ? 0 : 1);
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            char pre = s.charAt(i - 1);
            dp[i + 1] = c == '0' ? 0 : dp[i];
            if (pre == '1' || (pre == '2' && c <= '6')) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[n];
    }

    public int numDecodings2(String s) {
        int len = s.length();
        s = " " + s;
        int[] f = new int[len+1];
        f[0] = 1;
        for (int i = 1; i <= len; i++) {
            if (s.charAt(i) >= '1' && s.charAt(i) <= '9') {
                f[i] += f[i - 1];
            }
            int t = (int) (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (t >= 10 && t <= 26) {
                f[i] += f[i - 2];
            }
        }
        return f[len];
    }

    public static void main(String[] args) {
        LeetCode91 le = new LeetCode91();
        le.numDecodings("13");
        le.numDecodings2("13");
    }

}