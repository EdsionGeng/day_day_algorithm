package com.edison.algorithm.dp;

public class 乘积小于K的子数组 {

    public static int numSubArrayProductLessThanK(int[] nums, int k) {
        int l = 0, r = -1, value = 1, count = 0;
        while (r < nums.length - 1 && value < k) {
            r++;
            value *= nums[r];
            while (l <= r && value >= k) {
                value /= nums[l];
                l++;
            }
            count += r - l + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubArrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }
}
