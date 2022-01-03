package com.edison.algorithm.algorithm;


/**
 * 描述:
 * 加权连通图最短路径算法
 *
 * @author gengyc
 * @create 2021-12-21 17:03
 */
public class BellmanFord {
    public long[] result;

    static class Edge {
        public int a;
        public int b;
        public int value;

        Edge(int a, int b, int value) {
            this.a = a;
            this.b = b;
            this.value = value;
        }
    }

    public boolean getShortestPaths(int n, Edge[] A) {
        result = new long[n];
        for (int i = 1; i < n; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < A.length; j++) {
                if (result[A[j].b] > result[A[j].a] + A[j].value) {
                    result[A[j].b] = result[A[j].a] + A[j].value;
                }
            }
        }
        boolean judge = true;
        for (int i = 1; i < n; i++) {
            if (result[A[i].b] > result[A[i].a] + A[i].value) {
                judge = false;
                break;
            }
        }
        return judge;

    }

    public static void main(String[] args) {
        BellmanFord test = new BellmanFord();

        int n = 6;
        int p = 18;
        Edge[] A = new Edge[p];
        A[0] = new Edge(0, 1, -6);
        A[1] = new Edge(0, 2, 3);
        A[2] = new Edge(1, 2, 2);
        A[3] = new Edge(1, 3, 5);
        A[4] = new Edge(2, 3, 3);
        A[5] = new Edge(2, 4, 4);
        A[6] = new Edge(3, 4, 2);
        A[7] = new Edge(3, 5, 3);
        A[8] = new Edge(4, 5, 6);
        A[9] = new Edge(1, 0, -6);
        A[10] = new Edge(2, 0, 3);
        A[11] = new Edge(2, 1, 2);
        A[12] = new Edge(3, 1, 5);
        A[13] = new Edge(3, 2, 3);
        A[14] = new Edge(4, 2, 4);
        A[15] = new Edge(4, 3, 2);
        A[16] = new Edge(5, 3, 3);
        A[17] = new Edge(5, 4, 5);

        if (test.getShortestPaths(n, A)) {
            for (int i = 0; i < test.result.length; i++) {
                System.out.print(test.result[i] + " ");
            }
        } else {
            System.out.println("给定图存在负环，没有最短距离");
        }
    }
/**
 * 请输入一个图的顶点总数n和边总数p：
 * 6 18
 * 请输入具体边的数据：
 * 0 1 6
 * 0 2 3
 * 1 2 2
 * 1 3 5
 * 2 3 3
 * 2 4 4
 * 3 4 2
 * 3 5 3
 * 4 5 5
 * 1 0 6
 * 2 0 3
 * 2 1 2
 * 3 1 5
 * 3 2 3
 * 4 2 4
 * 4 3 2
 * 5 3 3
 * 5 4 5
 */
}