package com.edison.algorithm.graph;

import java.util.ArrayList;

public class SPFA {
    public long[] result;

    class Edge {
        public int a;
        public int b;
        public int value;

        Edge(int a, int b, int value) {
            this.a = a;
            this.b = b;
            this.value = value;
        }
    }

    public boolean getShortestPaths(int n, int s, Edge[] A) {
        ArrayList<Integer> list = new ArrayList<>();
        result = new long[n];
        boolean[] used = new boolean[n];
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Integer.MAX_VALUE;
            used[i] = false;
        }
        result[s] = 0;
        used[s] = true;
        num[s] = 1;
        list.add(s);
        while (list.size() != 0) {
            int a = list.get(0);
            list.remove(0);
            for (int i = 0; i < A.length; i++) {
                if (a == A[i].a && result[A[i].b] > result[A[i].a] + A[i].value) {
                    result[A[i].b] = result[A[i].a] + A[i].value;
                    if (!used[A[i].b]) {
                        list.add(A[i].b);
                        num[A[i].b]++;
                        if (num[A[i].b] > n) {
                            return false;
                        }
                        used[A[i].b] = true;
                    }
                }
            }
            used[a] = false;
        }
        return true;
    }
}
