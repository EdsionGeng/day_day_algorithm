package com.edison.algorithm.array;

import netscape.security.UserTarget;

public class 乘积最大子数组 {

    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, min = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = min;
                min = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
    }
}
