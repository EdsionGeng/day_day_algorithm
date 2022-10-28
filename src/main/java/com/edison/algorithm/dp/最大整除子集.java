package com.edison.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最大整除子集 {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0, cur = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > ans) {
                ans = dp[i];
                cur = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (ans == 0) {
            res.add(nums[0]);
            return res;
        }

        for (int i = n - 1; i >= 0 && ans >= 0; i--) {
            if (ans == dp[i] && nums[cur] % nums[i] == 0) {
                cur = i;
                res.add(nums[i]);
                ans--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = largestDivisibleSubset(new int[]{1, 2, 4, 7});
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
