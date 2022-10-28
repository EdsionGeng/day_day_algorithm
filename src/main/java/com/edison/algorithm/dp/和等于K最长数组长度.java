package com.edison.algorithm.dp;

public class 和等于K最长数组长度 {

    public static int maxSubArrayLen(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int add = sum[j + 1] - sum[i];
                if (add == k) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
        System.out.println(maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1));
    }
}
