package com.edison.algorithm.leetcode;

import netscape.security.UserTarget;

//子数组最大平均数
public class LeetCode643 {


    public int findMaxAverage(int[] nums, int k) {
        int sum = 0, l = 0, maxAvg = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k - 1) {
                maxAvg = Math.max(maxAvg, sum / k);
                sum -= nums[l];
                l += 1;
            }
        }
        return maxAvg;
    }

    public static void main(String[] args) {
        LeetCode643 le = new LeetCode643();
        le.findMaxAverage(new int[]{5, 3, 4, 8, 9, 4}, 3);
    }
}
