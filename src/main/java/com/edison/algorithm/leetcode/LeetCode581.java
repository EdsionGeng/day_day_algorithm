package com.edison.algorithm.leetcode;

import java.util.Arrays;

public class LeetCode581 {
    public int findUnsortedSubarray(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }
        int[] numSorted = new int[nums.length];
        System.arraycopy(nums, 0, numSorted, 0, nums.length);
        Arrays.sort(numSorted);
        int left = 0;
        while (nums[left] == numSorted[left]) {
            left++;
        }
        int right = nums.length - 1;
        while (nums[right] == numSorted[right]) {
            right--;
        }
        return right - left + 1;
    }

    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
