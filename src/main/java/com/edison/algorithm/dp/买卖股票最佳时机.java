package com.edison.algorithm.dp;

import java.util.Arrays;

public class 买卖股票最佳时机 {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;
        int res = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res > 0 ? res : 0;
    }

    public static int maxProfit2(int[] prices) {


        int n = prices.length;
        if (n == 1) return 0;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i]);

        }
        return dp0;

    }

    public static int maxProfit3(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;

    }

    public static int maxProfit4(int[] prices, int k) {
        if (prices.length == 0) return 0;
        int n = prices.length;
        k = Math.min(k, n / 2);
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];

        buy[0][0] = -prices[0];
        for (int i = 1; i <= k; i++) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i < n; i++) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        return Arrays.stream(sell[n - 1]).max().getAsInt();

    }

    public int maxProfit5(int[] prices) {
        if(prices.length==0) return 0;



return 0;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));

    }
}
