package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 删除排序数组中的重复项
 *
 * @author gengyc
 * @create 2021-12-31 14:54
 */
public class LeetCode26 {
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums.length;
        }
        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 3};
        System.out.println(removeDuplicates(nums));
    }

}