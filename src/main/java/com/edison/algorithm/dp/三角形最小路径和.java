package com.edison.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

public class 三角形最小路径和 {
    int res;
    int n = 0;

    public int minmumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        dfs(triangle, 0);
        return res;
    }

    public void dfs(List<List<Integer>> list, int level) {
        if (level >= n) return;
        List<Integer> iter = list.get(level);
        int min = iter.get(0);
        for (int i = 1; i < iter.size(); i++) {
            min = Math.min(min, iter.get(i));
        }
        res += min;
        dfs(list, level + 1);


    }

    public int minmumTotal2(int[][] triangle) {
        int n = triangle.length;
        int[] dp = new int[triangle[triangle.length - 1].length];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle[i][j];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        三角形最小路径和 le = new 三角形最小路径和();
        List<List<Integer>> list = new ArrayList<>();
        List list1 = new ArrayList();
        list1.add(2);
        List list2 = new ArrayList();
        list2.add(3);
        list2.add(4);
        List list3 = new ArrayList();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List list4 = new ArrayList();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        System.out.println(le.minmumTotal(list));
    }
}
