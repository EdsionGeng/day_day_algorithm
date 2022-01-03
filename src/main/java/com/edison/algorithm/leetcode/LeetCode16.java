package com.edison.algorithm.leetcode;

import java.util.Arrays;

/**
 * 描述:
 * 最接近三数之和
 *
 * @author gengyc
 * @create 2021-12-27 16:07
 */
public class LeetCode16 {
    public static int threeSumCloset(int[] nums, int target) {
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[i] + nums[l] + nums[r];
                if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    return target;
                }
            }
        }
        return closestNum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4,3,5};
        System.out.println(threeSumCloset(nums,1));
    }
}