package com.edison.algorithm.leetcode;

/**
 * 岛屿周长
 */
public class LeetCode463 {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                return dfs(grid, i, j);
            }
        }
        return 0;
    }

    int dfs(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) return 1;
        if (grid[r][c] == 0) return 1;
        if (grid[r][c] != 1) return 0;
        grid[r][c] = 2;
        return dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r , c - 1);

    }

    boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;

    }
}
