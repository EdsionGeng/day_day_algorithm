package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

//1-n没有出现过的整数
public class LeetCode448 {
    public List findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            int pos = Math.abs(num) - 1;
            if (nums[pos] > 0) {
                nums[pos] = -nums[pos];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode448 le = new LeetCode448();
        System.out.println(le.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
