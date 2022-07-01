package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 最小高度树
 * @Date 2022/4/24上午10:25
 * @Created by edsiongeng
 */
public class LeetCode310 {
    //对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
    //
    //格式
    //
    //该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。
    //
    //你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。
    //
    //示例 1:
    //
    //输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
    //
    //    0
    //    |
    //    1
    //   / \
    //  2   3
    //————————————————
    //版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/a1439775520/article/details/104693751
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        int[][] gra = new int[n][];
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (gra[a] == null) gra[a] = edge;
            else gra[b] = edge;
        }
        int root = getRoot(gra);
        int[] node = getNode(gra, root);
        root = reverse(gra, root, node[0]);
        node = getNode(gra, root);

        int len = node[1] / 2;
        int p = node[0];
        while (len-- != 0) p = getNext(gra, p);
        res.add(p);
        if ((node[1] & 1) == 1) res.add(getNext(gra, p));
        return res;
    }

    private int[] getNode(int[][] gra, int root) {
        int n = gra.length;
        int max = 0, node = 0;
        int[] h = new int[n];
        int[] stack = new int[n];
        int size = 0;
        for (int i = 0; i < n; i++) {
            int p = i, count = 0;
            while (p != root && h[p] == 0) {
                stack[size++] = p;
                p = getNext(gra, p);
            }
            while (size != 0) {
                int temp = stack[--size];
                h[temp] = h[p] + 1;
                if (h[temp] > max) {
                    max = h[temp];
                    node = temp;
                }
                p = temp;
            }
        }
        return new int[]{node, h[node]};
    }

    private int reverse(int[][] gra, int root, int p) {
        int ret = p;
        int[] pre = null;
        while (p != root) {
            int next = getNext(gra, p);
            int[] temp = gra[p];
            gra[p] = pre;
            pre = temp;
            p = next;
        }
        gra[root] = pre;
        return ret;
    }

    private int getRoot(int[][] gra) {
        int p = 0;
        while (gra[p] != null) p = getNext(gra, p);
        return p;
    }

    private int getNext(int[][] gra, int p) {
        int[] ret = gra[p];
        return ret[0] == p ? ret[1] : ret[0];
    }

    public static void main(String[] args) {
        LeetCode310 le = new LeetCode310();
        le.findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});
    }
}
