package com.edison.algorithm.leetcode;

/**
 * @Description 戳气球
 * @Date 2022/4/26下午1:52
 * @Created by edsiongeng
 */
public class LeetCode312 {
    private int[][] dp;

    public void fill(int[] nums, int from, int to) {
        int max = 0, maxleft = 0, maxRight = 0, res = 0;
        for (int i = from; i <= to; i++) {
            maxleft = dp[from][i - 1];
            maxRight = dp[i + 1][to];
            res = maxleft + maxRight + nums[from - 1] * nums[i] * nums[to + 1];
            max = Math.max(max, res);
        }
        dp[from][to] = max;

    }

    public int maxCoins(int[] nums) {
        int length = nums.length;
        int[] expandNums = new int[length + 2];
        System.arraycopy(nums, 0, expandNums, 1, length);
        expandNums[0] = expandNums[expandNums.length - 1] = 1;
        dp = new int[length + 2][length + 2];
        for (int span = 0; span < length; span++) {
            for (int from = length - span; from > 0; from--) {
                fill(expandNums, from, from + span);
            }
        }
        return dp[1][length];
    }

    public static void main(String[] args) {
        LeetCode312 le = new LeetCode312();
        System.out.println(le.maxCoins(new int[]{3, 1, 5, 8}));
    }
}
