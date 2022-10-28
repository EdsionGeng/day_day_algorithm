package com.edison.algorithm.dp;

import java.util.HashMap;
import java.util.Map;

public class 连续的子数组和 {

    public boolean checkSubarraySum(int[] nums, int k) {

        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
