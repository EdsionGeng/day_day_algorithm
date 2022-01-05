package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 搜索插入位置
 *
 * @author gengyc
 * @create 2022-01-05 15:52
 */
public class LeetCode35 {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 你可以假设数组中无重复元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     * <p>
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     * <p>
     * 输入: [1,3,5,6], 0
     * 输出: 0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     * ————————————————
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        if (target < nums[left]) {
            return 0;
        }
        if (target > nums[right]) {
            return nums.length;
        }
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }

        }
        return left;
    }
}