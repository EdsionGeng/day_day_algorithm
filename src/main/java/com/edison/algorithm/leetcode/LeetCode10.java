package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 正则表达式匹配
 *
 * @author gengyc
 * @create 2021-12-24 15:55
 */
public class LeetCode10 {
    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 ‘.’ 和 ‘*’ 的正则表达式匹配。
     * <p>
     * ‘.’ 匹配任意单个字符
     * ‘*’ 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * <p>
     * 说明:
     * <p>
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     * 示例 1:
     * <p>
     * 输入:
     * s = “aa”
     * p = “a”
     * 输出: false
     * 解释: “a” 无法匹配 “aa” 整个字符串。
     * 示例 2:
     * <p>
     * 输入:
     * s = “aa”
     * p = “a*”
     * 输出: true
     * 解释: 因为 ‘*’ 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 ‘a’。因此，字符串 “aa” 可被视为 ‘a’ 重复了一次。
     * 示例 3:
     * <p>
     * 输入:
     * s = “ab”
     * p = “."
     * 输出: true
     * 解释: ".” 表示可匹配零个或多个（’*’）任意字符（’.’）。
     * 示例 4:
     * <p>
     * 输入:
     * s = “aab”
     * p = “cab”
     * 输出: true
     * 解释: 因为 ‘*’ 表示零个或多个，这里 ‘c’ 为 0 个, ‘a’ 被重复一次。因此可以匹配字符串 “aab”。
     * 示例 5:
     * <p>
     * 输入:
     * s = “mississippi”
     * p = “misisp*.”
     * 输出: false
     * ————————————————
     */
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] memory = new boolean[2][pLen + 1];
        memory[0][0] = true;
        int cur = 0, pre = 0;
        for (int i = 0; i <= sLen; i++) {
            cur = i % 2;
            pre = (i + 1) % 2;
            if (i > 1) {
                for (int j = 0; j <= pLen; j++) {
                    memory[cur][j] = false;
                }
            }
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {

                    memory[cur][j] = memory[cur][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) ||
                            p.charAt(j - 2) == '.') && memory[pre][j]);
                } else {
                    memory[cur][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                            && memory[pre][j - 1];
                }
            }
        }
        return memory[cur][pLen];
    }

    public static void main(String[] args) {
        LeetCode10 le = new LeetCode10();
        System.out.println(le.isMatch("ab",".*"));
        System.out.println(le.isMatch("aab","c*a*b"));
        System.out.println(le.isMatch("mississippi","mis*is*p*."));
    }
}