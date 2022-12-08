package com.edison.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int m = nums.length;
        if (m < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < m; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode523 le = new LeetCode523();
        le.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6);
    }
}
