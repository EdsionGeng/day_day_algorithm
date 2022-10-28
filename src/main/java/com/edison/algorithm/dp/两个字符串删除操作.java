package com.edison.algorithm.dp;

public class 两个字符串删除操作 {

    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            int[] temp = new int[word2.length() + 1];
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0) continue;
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    temp[j] = dp[j - 1];
                } else {
                    temp[j] = Math.min(dp[j], temp[j - 1]) + 1;
                }
            }
            dp = temp;
        }
        return dp[word2.length()];
    }
}
