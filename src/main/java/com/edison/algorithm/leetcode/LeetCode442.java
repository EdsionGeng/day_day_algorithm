package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

//数组中重复数据
public class LeetCode442 {
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> duplicates = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int index = Math.abs(num) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                duplicates.add(index + 1);
            }
        }
        return duplicates;

    }
}
