package com.edison.algorithm.leetcode;

import java.util.Arrays;

//最长连续序列变种题
public class LeetCode594 {

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int begin = 0, res = 0;
        for (int end = 1; end < nums.length; end++) {
            while (nums[end] - nums[begin] > 1) {
                begin++;
            }
            if (nums[end] - nums[begin] == 1) {
                res = Math.max(res, end - begin + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode594 le = new LeetCode594();
        System.out.println(le.findLHS(new int[]{
                1, 3, 2, 2, 5, 2, 3, 7
        }));
    }
}
