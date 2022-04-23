package com.edison.algorithm.leetcode;

/**
 * @Description 缺失数字
 * @Date 2022/4/9下午12:33
 * @Created by edsiongeng
 */
public class LeetCode268 {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
            res ^= i;

        }
        return res;
    }

    public int missingNumber2(int[] nums) {
        boolean[] flag = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            flag[nums[i]] = true;
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == false) return i;
        }
        return -1;
    }
}
