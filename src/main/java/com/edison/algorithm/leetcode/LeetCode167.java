package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 两数之和 输入有序数组
 *
 * @author gengyc
 * @create 2022-02-28 17:12
 */
public class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int low = 0, high = numbers.length;
        while (low < high) {
            if (numbers[low] + numbers[high] > target) {
                high--;
            } else if (numbers[low] + numbers[high] < target) {
                low++;
            } else {
                res[0] = low + 1;
                res[1] = high + 1;
                break;
            }
        }
        return res;

    }
}