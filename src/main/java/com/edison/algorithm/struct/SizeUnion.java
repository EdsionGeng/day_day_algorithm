package com.edison.algorithm.struct;

/**
 * 描述:
 * 并查集Size优化
 * 集合数量少的一方合并到数量多的一方
 *
 * @author gengyongchang
 * @create 2021-02-19 16:33
 */
public class SizeUnion {
    private int[] parent;
    private int count;
    private int[] size;

    public SizeUnion(int N) {
        parent = new int[N];
        size = new int[N];
        this.count = N;
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;

        }
    }

    public int find(int p) {
        assert p > 0 && p < count;
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    boolean isConnect(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        } else {
            parent[pRoot] = qRoot;
        }

    }

    public void sizeUnionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        } else {
            if (size[pRoot] <= size[qRoot]) {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            } else {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            }
        }
    }

}