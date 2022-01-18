package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 组合
 *
 * @author gengyc
 * @create 2022-01-18 10:20
 */
public class LeetCode77 {
    //给定两个整数 n 和 k，返回 1 … n 中所有可能的 k 个数的组合。
//
//示例:
//
//输入: n = 4, k = 2
//输出:
//[
//[2,4],
//[3,4],
//[2,3],
//[1,2],
//[1,3],
//[1,4],
//]
    private List<List<Integer>> res;


    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n < 1 || k < 1 || n < k) {
            return res;
        }
        List<Integer> selected = new ArrayList<>();
        pickNext(1, n, k, selected);
        return res;
    }

    public void pickNext(int min, int max, int k, List<Integer> selected) {
        if (k == 0) {
            res.add(new ArrayList<>(selected));
            return;
        }
        for (int i = min; i < max - k + 1; i++) {
            selected.add(i);
            pickNext(i + 1, max, k - 1, selected);
            selected.remove(selected.size() - 1);
        }
    }
}