package com.edison.algorithm.graph;


import java.util.Arrays;

//Connecting Cities With Minimum Cost
public class LeetCode1135 {


    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int cost = 0;
        for (int[] edge : connections) {
            if (union(edge[0], edge[1], parent)) {
                cost += edge[2];
            }
        }
        int p = -1;
        for (int i = 1; i < n; i++) {
            int root = findRoot(i, parent);
            if (p == -1) {
                p = root;
            } else if (p != root) {
                return -1;
            }

        }

        return cost;


    }

    public int findRoot(int x, int[] parent) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public boolean union(int a, int b, int[] parent) {
        a = findRoot(a, parent);
        b = findRoot(b, parent);
        if (a == b) return false;
        parent[a] = b;
        return true;
    }


    public static void main(String[] args) {

    }
}
