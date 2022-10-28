package com.edison.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode560 {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            if (map.containsKey( preSum-k)) {
                count += map.get( preSum-k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);

        }
        return count;
    }




    public static void main(String[] args) {
        LeetCode560 leetCode560 = new LeetCode560();
        System.out.println(leetCode560.subarraySum(new int[]{1, 2, 3}, 3));
    }
}
