package com.edison.algorithm.dp;

public class 寻找数组中心下标 {

    public static int pivotIndex(int[] nums) {
        int sum = 0, presum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (presum == sum - nums[i] - presum) return i;
            presum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex(new int[]{1, 2, 3}));
    }
}
