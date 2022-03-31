package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 数组第K个大元素
 *
 * @author gengyc
 * @create 2022-03-10 17:33
 */
public class LeetCode215 {

    public int findKthLargest(int[] nums, int k) {
        if (nums.length < 2) {
            return nums.length == 1 ? nums[0] : -1;
        }
        return countingSort(nums, k);
    }

    private int countingSort(int[] nums, int k) {
        int max = 0, min = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int length = max - min + 1;
        int[] newArray = new int[length];
        for (int i = 0; i < nums.length; i++) {
            newArray[nums[i] - min]++;
        }
        int j = 0;
        for (int i = newArray.length - 1; i >= 0; i--) {
            if (newArray[i] > 0) {
                j = newArray[i] + j;
                if (j >= k) {
                    return i + min;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {-1, 5, 7, 7, 10};
        LeetCode215 le = new LeetCode215();
        le.findKthLargest(array,3);
    }
}