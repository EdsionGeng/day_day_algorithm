package com.edison.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述:
 * 存在重复元素
 *
 * @author gengyc
 * @create 2022-03-11 17:17
 */
public class LeetCode217 {
    public boolean isRepeat(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size() == nums.length;
    }

}