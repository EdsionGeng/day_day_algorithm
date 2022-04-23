package com.edison.algorithm.leetcode;

/**
 * @Description 完全平方和
 * @Date 2022/4/15下午5:32
 * @Created by edsiongeng
 */
public class LeetCode279 {
    //给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, …）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
    //
    //示例 1:
    //
    //输入: n = 12
    //输出: 3
    //解释: 12 = 4 + 4 + 4.
    //示例 2:
    //
    //输入: n = 13
    //输出: 2
    //解释: 13 = 4 + 9.
    public int numSquare(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (i >= j * j) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        return dp[n];
    }

    public int numSquare2(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7)
            return 4;
        int a = 0;
        while ((a * a) <= n) {
            int b = (int) Math.pow((n - a * a), 0.5);
            if (a * a + b * b == n) {
                if (a != 0 && b != 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
            a++;
        }
        return 3;
    }
}
