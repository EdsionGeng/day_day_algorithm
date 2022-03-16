package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 买卖股票最佳时机
 *
 * @author gengyc
 * @create 2022-01-27 16:37
 */
public class LeetCode121 {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}