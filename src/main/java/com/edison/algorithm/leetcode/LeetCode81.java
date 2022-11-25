package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 搜索旋转排序数组2
 *
 * @author gengyc
 * @create 2022-01-18 13:28
 */
public class LeetCode81 {

    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            while (low < high && nums[low] == nums[low + 1]) {
                low++;
            }
            while (low < high && nums[high] == nums[high - 1]) {
                high--;
            }
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 把数组大致分为两组，一组为左侧未旋转有序数组，一组为右侧旋转有序数组
            // 如[3 4 5 1 2]， [3，4，5]称为左侧，[1，2]称为右侧

            // 0~mid有序，向后规约条件
            // nums[mid] >= nums[0] 表示0~mid有序
            // target > nums[mid] 表示target位于左侧且大于nums[mid],向后规约
            // target < nums[0] 表示target位于右侧，向后规约
            if (nums[mid] > nums[0] && (target > nums[mid] || target < nums[0])) {
                low = mid + 1;
            } else if (nums[mid] < nums[0] && target > nums[mid] && target < nums[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public boolean search2(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[start] == nums[mid]) {
                start++;
            } else if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return false;

    }
}