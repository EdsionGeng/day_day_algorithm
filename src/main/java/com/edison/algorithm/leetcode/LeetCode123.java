package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 买卖股票最佳时机3
 *
 * @author gengyc
 * @create 2022-01-27 16:58
 */
public class LeetCode123 {

    public int maxProfit(int[] prices) {
        int fstBuy = Integer.MIN_VALUE, fstSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;
        for (int p : prices) {
            fstBuy = Math.max(fstBuy, -p);
            fstSell = Math.max(fstSell, fstBuy + p);
            secBuy = Math.max(secBuy, fstSell - p);
            secSell = Math.max(secSell, secBuy + p);
        }
        return secSell;
    }

    public static void main(String[] args) {
        LeetCode123 le = new LeetCode123();
        System.out.println(le.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}