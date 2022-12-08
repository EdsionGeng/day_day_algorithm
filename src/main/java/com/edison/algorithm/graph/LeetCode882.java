package com.edison.algorithm.graph;

import java.util.*;

//细分图中的可到达节点
public class LeetCode882 {

    public int reachableNodes(int[][] edges, int maxMoves, int n) {

        List<int[]>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<int[]>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], nodes = edge[2];
            adjList[u].add(new int[]{v, nodes});
            adjList[v].add(new int[]{u, nodes});
        }
        Map<Integer, Integer> used = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int reachableNodes = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty() && pq.peek()[0] <= maxMoves) {
            int[] pair = pq.poll();
            int step = pair[0], u = pair[1];
            if (!visited.add(u)) {
                continue;
            }
            reachableNodes++;
            for (int[] next : adjList[u]) {
                int v = next[0], nodes = next[1];
                if (nodes + step + 1 < maxMoves && !visited.contains(v)) {
                    pq.offer(new int[]{nodes + step + 1, v});
                }
                used.put(encode(u, v, n), Math.min(nodes, maxMoves - step));
            }
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], nodes = edge[2];
            reachableNodes += Math.min(nodes, used.getOrDefault(encode(u, v, n), 0)
                    + used.getOrDefault(encode(v, u, n), 0));
        }
        return reachableNodes;
    }

    public int encode(int u, int v, int n) {
        return u * n + v;
    }

    public static void main(String[] args) {
        LeetCode882 le = new LeetCode882();
        le.reachableNodes(new int[][]{{0, 1, 10}, {0, 2, 1}, {1, 2, 2}}, 6, 3);
    }
}
