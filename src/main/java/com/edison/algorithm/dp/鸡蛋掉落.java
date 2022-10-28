package com.edison.algorithm.dp;

public class 鸡蛋掉落 {

    public static int superEggDrop(int k, int n) {
        int[][] dp = new int[n + 1][k + 1];
        //只有一个鸡蛋看层数
        for (int i = 1; i <= n; i++) {
            dp[i][1] = i;
        }
        //只有一层，多少鸡蛋都是一层
        for (int i = 1; i <= k; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                //碎dp[m-1][j-1] 不碎 dp[i-m][j]
                int start = 2, end = i, pos = start;
                while (start <= end) {
                    int mid = start + (end - start) / 2;
                    if (dp[mid - 1][j - 1] >= dp[i - mid][j]) {
                        pos = mid;
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
                dp[i][j] = Math.max(dp[pos - 1][j - 1], dp[i - pos][j]) + 1;
            }
        }

        return dp[n][k];
    }
}
