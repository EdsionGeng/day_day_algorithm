package com.edison.algorithm.leetcode;

public class LeetCode540 {

    public int singleNpnDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    low = mid;
                } else {
                    high = mid;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return nums[low];
    }
}
