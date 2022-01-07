package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 * 组合总和2
 *
 * @author gengyc
 * @create 2022-01-07 9:47
 */
public class LeetCode40 {
    /**
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。
     * 示例 1:
     * <p>
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     * [1, 7],
     * [1, 2, 5],
     * [2, 6],
     * [1, 1, 6]
     * ]
     * 示例 2:
     * <p>
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 所求解集为:
     * [
     * [1,2,2],
     * [5]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum-ii
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> res, int start, List<Integer> tmpList) {
        if (target == 0) {
            res.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (target - candidates[i] >= 0) {
                tmpList.add(candidates[i]);
                backtrack(candidates, target - candidates[i], res, i + 1, tmpList);
                tmpList.remove(tmpList.size() - 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        LeetCode40 leetCode40 = new LeetCode40();
        leetCode40.combinationSum2(candidates, 8);

        int[] num=new int[2];
        num[0]=1;
        System.out.println(num.length);
    }
}