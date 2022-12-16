package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode323 {

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int count = 0;
        for (int u = 0; u < n; u++) {
            if (!visited[u]) {
                count++;
                dfs(u, visited, graph);
            }
        }
        return count;
    }


    private void dfs(int u, boolean[] visited, List<List<Integer>> graph) {
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                dfs(v, visited, graph);
            }
        }
    }
}
