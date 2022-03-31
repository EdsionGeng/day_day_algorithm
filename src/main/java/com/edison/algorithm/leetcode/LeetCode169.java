package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 多数元素
 *
 * @author gengyc
 * @create 2022-02-28 17:47
 */
public class LeetCode169 {
    public int majorityElement(int[] nums) {
        int count = 1;
        int maj = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maj == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    maj = nums[i + 1];
                }
            }
        }
        return maj;
    }

}