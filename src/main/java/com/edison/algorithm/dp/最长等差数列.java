package com.edison.algorithm.dp;

import java.util.HashSet;
import java.util.Set;

public class 最长等差数列 {

    public static int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            s.add(num);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int result = nums[j] - nums[i], y = nums[j] + result;
                int length = 2;
                while (s.contains(y)) {
                    y += result;
                    ans = Math.max(ans, ++length);
                }
            }
        }
        return ans >= 1 ? ans : 0;
    }

    public static void main(String[] args) {
        System.out.println(longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));

    }
}
