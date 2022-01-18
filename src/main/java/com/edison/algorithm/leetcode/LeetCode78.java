package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 子集
 *
 * @author gengyc
 * @create 2022-01-18 10:46
 */
public class LeetCode78 {
    //给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
    //
    //说明：解集不能包含重复的子集。
    //
    //示例:
    //
    //输入: nums = [1,2,3]
    //输出:
    //[
    //[3],
    //[1],
    //[2],
    //[1,2,3],
    //[1,3],
    //[2,3],
    //[1,2],
    //[]
    //]
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}