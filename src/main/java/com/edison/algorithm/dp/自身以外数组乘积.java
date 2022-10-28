package com.edison.algorithm.dp;

import java.util.Arrays;

public class 自身以外数组乘积 {

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for (int i = 0; i < nums.length - 1; i++) {
            res[i + 1] = res[i] * nums[i];
        }
        int multipy = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= multipy;
            multipy = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(productExceptSelf(new int[]{1, 2, 3, 4}));
    }
}
