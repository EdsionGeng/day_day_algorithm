package com.edison.algorithm.leetcode;


import java.util.LinkedList;
import java.util.Queue;

//LFU Cache
public class LeetCode547 {

    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < cities; k++) {
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            queue.offer(k);
                        }
                    }
                }
                provinces++;
            }
        }
        return provinces;
    }

    public int findCircleNum2(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, cities, i);
                provinces++;
            }
        }

        return provinces;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int cities, int i) {
        for (int j = 0; j < cities; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, cities, j);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode547 le = new LeetCode547();
        le.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});
    }
}
