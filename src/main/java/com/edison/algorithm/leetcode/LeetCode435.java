package com.edison.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode435 {

    public int removeArea(int[][] nums) {

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0]?o1[1] - o2[1]:o1[0] - o2[0];
            }
        });

        int total = 0, prev = nums[0][1];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i][0] < prev) {
                total++;
            } else {
                prev = nums[i][1];
            }
        }
        return total;

    }
}
