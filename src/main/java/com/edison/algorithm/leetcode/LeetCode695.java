package com.edison.algorithm.leetcode;

//岛屿最大面积
public class LeetCode695 {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int a = area(grid, i, j);
                    res = Math.max(res, a);
                }
            }
        }
        return res;
    }

    int area(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) return 0;
        if (grid[r][c] != 1) return 0;
        grid[r][c] = 2;
        return 1 + area(grid, r + 1, c) + area(grid, r - 1, c) + area(grid, r, c + 1) + area(grid, r, c - 1);
    }

    public boolean inArea(int[][] grid, int x, int y) {
        return x >=0 && x <grid.length && y >= 0 && y <grid[0].length;
    }

    public static void main(String[] args) {
        LeetCode695 le = new LeetCode695();
//11000
//11000
//00100
//00011
       int area= le.maxAreaOfIsland(new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}});
        System.out.println(area);
    }
}
