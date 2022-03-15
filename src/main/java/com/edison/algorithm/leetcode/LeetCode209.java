package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 和之最小连续数组
 *
 * @author gengyc
 * @create 2022-03-02 14:41
 */
public class LeetCode209 {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int sum = 0;
        int len = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                len = len == 0 ? j - i + 1 : Math.min(len, j - i + 1);
                sum -= nums[i++];
            }
        }
        return len;
    }
}