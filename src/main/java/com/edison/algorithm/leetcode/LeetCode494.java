package com.edison.algorithm.leetcode;

//目标和
public class LeetCode494 {

    int count = 0;

    int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, 0, target, 0);
        return count;
    }

    void backtrack(int[] nums, int index, int target, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, index + 1, target, sum + nums[index]);
            backtrack(nums, index + 1, target, sum - nums[index]);
        }
    }

}
