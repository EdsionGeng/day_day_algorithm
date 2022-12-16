package com.edison.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

public class 等差数列划分 {
    //连续等差子数列
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

    //等差子数列个数
    public static int numberOfArithmeticSlices2(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Map<Long, Integer>[] f = new Map[n];
        for (int i = 0; i < n; i++) {
            f[i] = new HashMap<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticsSlices(new int[]{1, 2, 3, 5, 7}));
    }
}
