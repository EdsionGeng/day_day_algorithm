package com.edison.algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//网格中的最短路径
public class LeetCode1293 {

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = new int[]{0, 1, -1, 0};
        int[] dy = new int[]{1, 0, 0, -1};
        queue.offer(new int[]{0, 0, k});

        int[][] visited = new int[m][n];

        Arrays.fill(visited, -1);

        visited[0][0] = k;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] poll = queue.poll();
                int i = poll[0], j = poll[1], r = poll[2];
                if (i == m - 1 && j == n - 1) return step;
                for (int l = 0; l < 4; l++) {
                    int x = dx[l] + i;
                    int y = dy[l] + j;
                    if (x < 0 || y < 0 || x >= m || y >= n) continue;
                    int newR = r + (grid[x][y] == 1 ? -1 : 0);
                    if (newR > visited[x][y]) {
                        visited[x][y] = newR;
                        queue.offer(new int[]{x, y, newR});
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
