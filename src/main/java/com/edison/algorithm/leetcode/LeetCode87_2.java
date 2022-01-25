package com.edison.algorithm.leetcode;

/**
 * 描述:
 * dfs+记忆化递归+哈希
 *
 * @author gengyc
 * @create 2022-01-20 13:38
 */
public class LeetCode87_2 {
    int p1 = 10007, p2 = 1000000007;
    boolean has_init;
    int[] hash = new int[128];

    void init_hash() {
        if (!has_init) {
            for (int i = 0; i < 128; i++) {
                hash[i] = (p2 * i) ^ p1;
            }
        }
    }

    int len = 5;
    int[][] dp = new int[len + 1][len + 1];

    boolean dfs(int b1, int b2, int len) {
        if (len == 1) {
            return dp[b1][b1 + 1] == dp[b2 + 1][b2];
        }
        for (int i = 1; i < len; i++) {
            if (dp[b1][b1 + i] == dp[b2 + i][b2] && dp[b1 + i][b1 + len] == dp[b2 + len][b2 + i]) {
                if (dfs(b1, b2, i) && dfs(b1 + i, b2 + i, len - i)) return true;
            }
            if (dp[b1][b1 + i] == dp[b2 + len][b2 + len - i] && dp[b1 + i][b1 + len] == dp[b2 + len - i][b2]) {
                if (dfs(b1, b2 + len - i, i) && dfs(b1 + i, b2, len - i)) return true;
            }
        }
        return false;
    }

    boolean isScramble(String s1, String s2) {
        int len = s1.length();
        init_hash();
        for (int i = 0; i < len; i++) {
            int key = 1;
            for (int j = 1; j < len; ) {
                key *= hash[s1.toCharArray()[j]];
                dp[i][++j] = key;
            }
        }
        for (int i = 0; i < len; i++) {
            int key = 1;
            for (int j = i; j < len; ) {
                key *= hash[s2.toCharArray()[j]];
                dp[++j][i] = key;
            }
        }
        return dfs(0, 0, len);

    }

    public static void main(String[] args) {
        LeetCode87_2 le = new LeetCode87_2();
        System.out.println(le.isScramble("great","rgeat"));
    }
}