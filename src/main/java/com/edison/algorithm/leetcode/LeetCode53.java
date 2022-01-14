package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 最大子序和分治法
 *
 * @author gengyc
 * @create 2022-01-13 10:52
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int local = nums[0];
        int global = nums[0];
        for (int i = 1; i < nums.length; i++) {
            local = Math.max(nums[i], local + nums[i]);
            global = Math.max(local, global);
        }
        return global;
    }

    public int maxSubArray2(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}