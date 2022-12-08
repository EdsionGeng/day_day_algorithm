package com.edison.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

//迷宫
public class LeetCode490 {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }

    public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (visited[start[0]][start[1]]) {
            return false;
        }
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        visited[start[0]][start[1]] = true;
        int right = start[1] + 1, left = start[1] - 1, up = start[0] - 1, down = start[0] + 1;
        while (right < maze[0].length && maze[0][right] == 0) {
            right++;
        }
        if (dfs(maze, new int[]{start[0], right - 1}, destination, visited)) {
            return true;
        }
        while (left >= 0 && maze[start[0]][left] == 0) {
            left--;
        }
        if (dfs(maze, new int[]{start[0], left + 1}, destination, visited)) {
            return true;
        }
        while (up >= 0 && maze[up][start[1]] == 0) {
            up--;
        }
        if (dfs(maze, new int[]{up + 1, start[1]}, destination, visited)) {
            return true;
        }
        while (down < maze.length && maze[down][start[1]] == 0) {
            down++;
        }
        if (dfs(maze, new int[]{down - 1, start[1]}, destination, visited)) {
            return true;
        }
        return false;
    }

    public boolean dfsPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            if (s[0] == destination[0] && s[1] == destination[1]) return true;
            for (int[] dir : dirs) {
                int x = s[0] + dir[0];
                int y = s[1] = dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                if (!visited[x - dir[0]][y - dir[1]]) {
                    queue.add(new int[]{x - dir[0], y - dir[1]});
                    visited[x - dir[0]][y - dir[1]] = true;
                }
            }
        }
        return false;
    }
}
