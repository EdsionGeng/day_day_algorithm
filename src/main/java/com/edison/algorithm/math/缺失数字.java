package com.edison.algorithm.math;

public class 缺失数字 {
    public static int missingNumer(int[] nums) {
        int n = nums.length + 1, l = nums.length;
        int sum = (n * (n + 1)) / 2 - n;

        for (int i = 0; i < l; i++) {
            sum = sum - nums[i];

        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumer(new int[]{3, 0, 1,9,6,4,7,5,2}));
    }
}
