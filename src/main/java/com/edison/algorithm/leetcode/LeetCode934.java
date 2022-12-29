package com.edison.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

//最短的桥
public class LeetCode934 {

    int[][] grid, coordinates = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    Deque<int[]> edges;

    public int shortestBridge(int[][] grid) {

        int result = 0;
        boolean findIsland = false;
        edges = new ArrayDeque<>();
        this.grid = grid;

        for (int i = 0; i < grid.length && !findIsland; i++) {
            for (int j = 0; j < grid[0].length && !findIsland; j++) {
                if (findIsland = (grid[i][j] == 1)) markIsland(i, j);
            }
        }

        while (!edges.isEmpty()) {
            result++;
            int num = edges.size();
            for (int i = 0; i < num; i++) {
                int[] edge = edges.removeFirst();
                for (int[] c : coordinates) {
                    int x = edge[0] + c[0], y = edge[1] + c[1];
                    if (isLegal(x, y) && grid[x][y] == 0) {
                        edges.addLast(new int[]{x, y});
                        grid[x][y] = 2;
                    } else if (isLegal(x, y) && grid[x][y] == 1) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    public void markIsland(int row, int column) {
        if (!isLegal(row, column) || grid[row][column] == 2) return;
        if (grid[row][column] == 0) {
            grid[row][column] = 2;
            edges.addLast(new int[]{row, column});
            return;
        }
        grid[row][column] = 2;
        for (int[] c : coordinates) {
            markIsland(row + c[0], column + c[1]);
        }
    }

    public boolean isLegal(int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }
}
