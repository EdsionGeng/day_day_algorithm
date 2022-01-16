package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 全排列
 *
 * @author gengyc
 * @create 2022-01-12 13:29
 */
public class LeetCode46 {

    //给定一个没有重复数字的序列，返回其所有可能的全排列。
    //
    //示例:
    //
    //输入: [1,2,3]
    //输出:
    //[
    //[1,2,3],
    //[1,3,2],
    //[2,1,3],
    //[2,3,1],
    //[3,1,2],
    //[3,2,1]
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<>(), visited);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}