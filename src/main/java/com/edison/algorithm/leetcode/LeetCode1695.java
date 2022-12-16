package com.edison.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode1695 {


    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxSum = 0;
        int sum = 0, start = 0, end = 0;
        int length = nums.length;
        while (end < length) {
            int num = nums[end];
            sum += num;
            while (set.contains(num)) {
                sum -= nums[start];
                set.remove(nums[start]);
                start++;
            }
            set.add(num);
            maxSum = Math.max(maxSum, sum);
            end++;
        }


        return maxSum;
    }
}
