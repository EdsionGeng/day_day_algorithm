package com.edison.algorithm.dp;

public class 粉刷房子2 {

    public int minCost2(int[][] costs) {
        int[] cur = new int[costs.length];
        int[] next = new int[costs.length];
        int n = costs[0].length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs.length; i++) {


            for (int j = 0; j < n; i++) {

                for (int k = 0; k < n; k++) {
                    min = Math.min(costs[i][j], costs[i][k]);
                }
                next[j] = min + costs[i][j];
//                next[0] = Math.min(cur[1], cur[2]) + cs[0];
//                next[1] = Math.min(cur[0], cur[2]) + cs[1];
//                next[2] = Math.min(cur[0], cur[1]) + cs[2];
//                next[i] = costs[]

                cur = next.clone();
            }
        }
        // Arrays.fill(next,0);
        return 0;
    }

}
