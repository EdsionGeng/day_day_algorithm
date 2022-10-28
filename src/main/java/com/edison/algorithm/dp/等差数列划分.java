package com.edison.algorithm.dp;

public class 等差数列划分 {

    public static int numberOfArithmeticsSlices(int[] nums) {
        int dp = 0, sum = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp = 1 + dp;
                sum += dp;
            } else {
                dp = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticsSlices(new int[]{1,2,4,7,5}));
    }
}
