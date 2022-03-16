package com.edison.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 子集
 *
 * @author gengyongchang
 * @create 2021-07-22 17:03
 */
public class SubSet {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        gen(result, nums, new ArrayList<>(), visited);
        return result;
    }

    public void gen(List<List<Integer>> result, int[] nums, List<Integer> temp, boolean[] visited) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            temp.add(nums[i]);
            visited[i] = true;
            gen(result, nums, temp, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubSet sub = new SubSet();
        sub.permute(new int[]{1, 2, 3});
    }


}