package com.edison.algorithm.leetcode;

import java.util.Arrays;
import java.util.Random;

//打乱数组
public class LeetCode384 {
    private int[] nums;
    private Random random = new Random();

    LeetCode384(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);

        for (int i = 0; i < n; i++) {
            int r = i + random.nextInt(n - i);
            swap(copy, i, r);
        }
        return copy;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
