package com.edison.algorithm.leetcode;

import java.util.Arrays;

/**
 * 描述:
 * 不同子序列
 *
 * @author gengyc
 * @create 2022-01-26 15:36
 */
public class LeetCode115 {
//给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
//
//一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，“ACE” 是 “ABCDE” 的一个子序列，而 “AEC” 不是）
//
//示例 1:
//
//输入: S = “rabbbit”, T = “rabbit”
//输出: 3
//解释:
//
//如下图所示, 有 3 种可以从 S 中得到 “rabbit” 的方案。

    //(1)动态规划 但是效率并不高 20ms 35.83%
    //     * 大部分都是二维动态规划 有的代码相同但是是5ms 估计是测试用例有变动
    //     * 但是看到还是有节省的算法 所以一步一步往下优化
    //     *
    //     *    *  b  a  b  g  b  a  g
    //     * *  1  1  1  1  1  1  1  1
    //     * b  0  1  1  2  2  3  3  3
    //     * a  0  0  1  1  1  1  4  4
    //     * g  0  0  0  0  1  1  1  5

    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j < s.length(); j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

    /**
     * 二维换一维 严格按照二维的流程 参见上面矩阵 这个是15ms
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct2(String s, String t) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, 1);
        int pre = 1;
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                int temp = dp[j];
                if (j == 0) {
                    dp[j] = 0;
                } else {
                    if (t.charAt(i) == s.charAt(j - 1)) {
                        dp[j] = dp[j - 1] + pre;
                    } else {
                        dp[j] = dp[j - 1];
                    }
                }
                pre = temp;
            }
        }
        return dp[s.length()];
    }

    /**
     * 列主序 倒序计算 就不用保存临时值pre了
     * 可以按上图二维矩阵的顺序模仿一下 这个是11ms
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct3(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = t.length() - 1; j >= 0; j--) {
                if (t.charAt(j) == s.charAt(i)) {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[t.length()];
    }

    /**
     * 列主序 先构造字典 就不用遍历t了
     * 这样就优化成了答案上的2ms的了
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct4(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;
        int[] map = new int[128];
        Arrays.fill(map, -1);

        int[] nexts = new int[t.length()];
        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            nexts[i] = map[c];
            map[c] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = map[c]; j >= 0; j = nexts[j]) {
                dp[j + 1] += dp[j];
            }
        }
        return dp[t.length()];
    }

    public static void main(String[] args) {
        LeetCode115 le = new LeetCode115();
        le.numDistinct4("babgbag", "bag");
    }
}