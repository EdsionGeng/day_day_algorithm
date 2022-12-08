package com.edison.algorithm.bytedance;

public class byte2 {

    public int backToOrigin(int n) {
        int length = 10;
        int[][] dp = new int[n + 1][length];
        dp[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + length) % length] + dp[i - 1][(j + 1) % length];
            }
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        byte2 byte2 = new byte2();

        System.out.println(byte2.backToOrigin(2));
    }

}
