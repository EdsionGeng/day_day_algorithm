package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 * 组合总和
 *
 * @author gengyc
 * @create 2022-01-07 9:37
 */
public class LeetCode39 {
    //给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //
    //candidates 中的数字可以无限制重复被选取。
    //
    //说明：
    //
    //所有数字（包括 target）都是正整数。
    //解集不能包含重复的组合。
    //示例 1:
    //
    //输入: candidates = [2,3,6,7], target = 7,
    //所求解集为:
    //[
    //[7],
    //[2,2,3]
    //]
    //示例 2:
    //
    //输入: candidates = [2,3,5], target = 8,
    //所求解集为:
    //[
    //[2,2,2,2],
    //[2,3,3],
    //[3,5]
    //]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/combination-sum

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            if (target < 0) {
                break;
            }
            tmp_list.add(candidates[start]);
            backtrack(candidates, target - candidates[start], res, start, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode39 leetCode39 = new LeetCode39();
        leetCode39.combinationSum(new int[]{2,3,6,7},7);
    }
}