package com.edison.algorithm.struct;


/**
 * 描述:
 * Rank并查集优化
 *
 * @author gengyongchang
 * @create 2021-02-19 17:00
 */
public class RankUnion {
    private int[] parent;
    private int count;
    private int[] rank;

    public RankUnion(int n) {
        parent = new int[n];
        rank = new int[n];
        this.count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p) {
        assert p >= 0 && p < count;
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        } else if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot]++;
        }
    }

}