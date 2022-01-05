package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 移除元素
 *
 * @author gengyc
 * @create 2021-12-31 15:01
 */
public class LeetCode27 {
    public static int removeVal(int[] nums, int val) {
        int index = 0, len = nums.length;
        for (int k = 0; k < len - index; k++) {
            if (nums[k] == val) {
                nums[k] = nums[len - 1 - index];
                index++;
                k--;
            }
        }
        return len - index;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        System.out.println(removeVal(nums, 2));
    }

}