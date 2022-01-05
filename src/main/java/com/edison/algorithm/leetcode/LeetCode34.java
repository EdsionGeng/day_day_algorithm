package com.edison.algorithm.leetcode;

import java.util.Arrays;

/**
 * 描述:
 * 排序数组查找元素第一个和最后一个位置
 *
 * @author gengyc
 * @create 2022-01-05 15:39
 */
public class LeetCode34 {
    /**
     * 如果数组中不存在目标值，返回 [-1, -1]。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 示例 2:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     */
    public static int[] searchRange(int[] nums, int target) {
        int p = Arrays.binarySearch(nums, 8);
        if (p == -1) {
            return new int[]{-1, -1};
        }
        int a = p, b = p;
        while (a > 0 && nums[a - 1] == target) {
            a--;
        }
        while (b < nums.length - 1 && nums[b + 1] == target) {
            b++;
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 8, 8, 10};
        int[] result=searchRange(nums,8);
        for (int i = 0; i <result.length ; i++) {
            System.out.print(result[i] +" ");
        }
    }

}