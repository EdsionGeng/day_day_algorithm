package com.edison.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//最长递增子序列
//最长递增子序列 个数
public class LIS {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            maxans = Math.max(maxans, dp[i]);

        }
        return maxans;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if (res == j) res++;
        }
        return res;

    }

    //最长递增子序列个数
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxNum = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        // dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxNum = Math.max(dp[i], maxNum);
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxNum) ans += count[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        LIS lis = new LIS();
       // lis.lengthOfLIS2(new int[]{10, 9, 2, 5, 3, 7, 21, 18});
        System.out.println(lis.findNumberOfLIS(new int[]{10, 9, 2, 5, 3, 7, 21, 18}));

    }
}
