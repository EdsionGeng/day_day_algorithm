package com.edison.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

public class 最长定差子序列 {

    public int longestSubsequence(int[] nums, int difference) {
        int ans = 0;

        Map<Integer, Integer> dp = new HashMap<>();

        for (int v : nums) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }
}
