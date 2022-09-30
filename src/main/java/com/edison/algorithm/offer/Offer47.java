package com.edison.algorithm.offer;

//礼物最大价值
public class Offer47 {

    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;


        for (int i = 1; i < m; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            grid[i][0] = grid[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Offer47 o = new Offer47();
        o.maxValue(new int[][]{{1, 2, 5}, {3, 2, 1}});
    }
}
