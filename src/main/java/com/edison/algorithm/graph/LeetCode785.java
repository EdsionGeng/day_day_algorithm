package com.edison.algorithm.graph;


import java.util.LinkedList;
import java.util.Queue;

//给定一个图，判断是否可以二分
public class LeetCode785 {

    //bfs
    public boolean isBipartite1(int[][] graph) {
        int[] visited = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0) {
                continue;
            }
            queue.offer(i);
            visited[i] = 1;
            while (!queue.isEmpty()) {
                int v = queue.poll();
                for (int w : graph[v]) {
                    if (visited[w] == visited[v]) {
                        return false;
                    }
                    if (visited[w] == 0) {
                        visited[w] = -visited[v];
                        queue.offer(w);
                    }
                }
            }
        }
        return true;
    }

    //dfs
    public boolean isBipartite2(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0 && !dfs(graph, i, 1, visited)) {
                return false;
            }
        }
        return true;

    }

    private boolean dfs(int[][] graph, int v, int color, int[] visited) {
        if (visited[v] != 0) {
            return visited[v] == color;
        }
        visited[v] = color;
        for (int w : graph[v]) {
            if (!dfs(graph, w, -color, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite3(int[][] graph) {
        UnionFind uf = new UnionFind(graph.length);
        for (int i = 0; i < graph.length; i++) {
            int[] adjs = graph[i];

            for (int w : adjs) {
                if (uf.isConnected(i, w)) {
                    return false;
                }
                uf.union(adjs[0], w);
            }
        }
        return true;
    }


    class UnionFind {
        int[] roots;

        public UnionFind(int n) {
            roots = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
            }
        }

        public int find(int i) {
            if (roots[i] == i) {
                return i;
            }
            return roots[i] = find(roots[i]);
        }

        public boolean isConnected(int p, int q) {
            return find(q) == find(p);
        }


        public void union(int p, int q) {
            roots[find(p)] = find(q);
        }
    }

    public static void main(String[] args) {
        LeetCode785 le = new LeetCode785();
        le.isBipartite1(new int[][]{{1,3},{0,2},{1,3},{0,2}});
    }
}
