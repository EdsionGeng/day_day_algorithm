package com.edison.algorithm.dp;

import java.util.Arrays;

public class 粉刷房子 {


    public  static int minCost(int[][] costs) {
        int[] cur = new int[costs.length];
        int[] next = new int[costs.length];
        for (int[] cs : costs) {
            next[0] = Math.min(cur[1], cur[2]) + cs[0];
            next[1] = Math.min(cur[0], cur[2]) + cs[1];
            next[2] = Math.min(cur[0], cur[1]) + cs[2];

            cur = next.clone();
           // Arrays.fill(next,0);
        }
        int res = next[0];
        for (int i = 1; i < next.length; i++) {
            res = Math.min(next[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
    }
}
