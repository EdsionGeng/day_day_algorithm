package com.edison.algorithm.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//最大整除子集
public class LeetCode368 {

    public List<Integer> largestDivisibleSubSet(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxVal = dp[0];
        int maxSize = 1;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }
        //倒推获得最大子集
        List<Integer> res = new ArrayList<>();
        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
        }

        for (int i = len - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && (maxVal % nums[i]) == 0) {
                res.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode368 le = new LeetCode368();
        le.largestDivisibleSubSet(new int[]{1,2,3});
    }
}
