package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 组合总和3
 *
 * @author gengyc
 * @create 2022-03-11 9:44
 */
public class LeetCode216 {

    public static List<List<Integer>> result = new ArrayList<>();
    public List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int n, int k) {
        backTracking(list, 0, 1, 0, k, n);
        return result;
    }

    private void backTracking(List<Integer> list, int index, int c, int sum, int k, int n) {
        if (index == k && sum == n) {
            List<Integer> currentList = new ArrayList<>();
            currentList.addAll(list);
            result.add(currentList);
            return;
        }
        if (sum > n) {
            return;
        }
        for (int i = c; i <= 9; i++) {
            list.add(i);
            sum += i;
            backTracking(list, index + 1, i + 1, sum, k, n);
            list.remove(list.size() - 1);
            sum -= i;

        }
    }

    public static void main(String[] args) {
        LeetCode216 le = new LeetCode216();
        le.combinationSum3(9, 3);
        for (List<Integer> list : result) {
            for (Integer i:list
                 ) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        System.out.println(1+2);

    }

}