package com.edison.algorithm.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description TODO
 * @Date 2020/7/28下午11:05
 * @Created by edsiongeng
 */
public class Dijkstra {

    /**
     * 参数adjMatrix:为图的权重矩阵，权值为-1的两个顶点表示不能直接相连
     * 函数功能：返回顶点0到其它所有顶点的最短距离，其中顶点0到顶点0的最短距离为0
     */
    public int[] getShortestPaths(int[][] adjMatrix) {
        int[] result = new int[adjMatrix.length];
        boolean[] used = new boolean[adjMatrix.length];
        //顶点被遍历过
        used[0] = true;

        for (int i = 1; i < adjMatrix.length; i++) {
            result[i] = adjMatrix[0][i];
            used[i] = false;
        }

        for (int i = 1; i < adjMatrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int k = 0;
            for (int j = 1; j < adjMatrix.length; j++) {
                if (!used[j] && result[j] != -1 && min > result[j]) {
                    min = result[j];
                    k = j;
                }
            }
            used[k] = true;
            for (int j = 1; j < adjMatrix.length; j++) {
                if (!used[j]) {
                    if (adjMatrix[k][j] != -1 && (result[j] > min + adjMatrix[k][j] || result[j] == -1)) {
                        result[j] = min + adjMatrix[k][j];
                    }
                }
            }
        }
        return result;
    }

//    public static void main(String[] args) {
//        Dijkstra test = new Dijkstra();
//        int[][] adjMatrix =
//                {{0, 6, 3, -1, -1, -1},
//                 {6, 0, 2, 5, -1, -1},
//                 {3, 2, 0, 3, 4, -1},
//                 {-1, 5, 3, 0, 2, 3},
//                 {-1, -1, 4, 2, 0, 5},
//                 {-1, -1, -1, 3, 5, 0}};
//        int[] result = test.getShortestPaths(adjMatrix);
//        System.out.println("顶点0到图中所有顶点之间的最短距离为：");
//        for (int i = 0; i < result.length; i++){
//            System.out.print(result[i] + " ");
//        }
//
//    }

    public static void main(String[] args) {
        int[][] map = new int[6][6];
        map[0][1] = 2;
        map[0][2] = 3;
        map[0][3] = 6;
        map[1][0] = 2;
        map[1][4] = 4;
        map[1][5] = 6;
        map[2][0] = 3;
        map[2][3] = 2;
        map[3][0] = 6;
        map[3][2] = 2;
        map[3][4] = 1;
        map[3][5] = 3;
        map[4][1] = 4;
        map[4][3] = 1;
        map[5][1] = 6;
        map[5][3] = 3;

        //Floyd
//        for (int i = 0; i < 6; i++) {
//            for (int j = 0; j < 6; j++) {
//                for (int k = 0; k < 6; k++) {
//                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
//                }
//            }
//        }
//
//        // 输出
//        for (int i = 0; i < 6; i++) {
//            System.out.print("节点"+(i+1)+" 的最短路径");
//            for (int j = 0; j < 6; j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
        int[] len = new int[6];
        boolean[] visited = new boolean[6];
        for (int i = 0; i < len.length; i++) {
            len[i] = Integer.MAX_VALUE;
        }
        Queue<Node> q1 = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.length - o2.length;
            }
        });
        len[0] = 0;

        q1.add(new Node(0, 0));
        while (!q1.isEmpty()) {
            Node t1 = q1.poll();
            int index = t1.x;
            int length = t1.length;
            visited[index] = true;
            for (int i = 0; i < map[index].length; i++) {
                if (map[index][i] != 0 && !visited[i]) {
                    Node node = new Node(i, length + map[index][i]);
                    if (len[i] > node.length) {
                        len[i] = node.length;
                        q1.add(node);
                    }
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(len[i]);
        }
    }

    static class Node {
        int x;
        int length;

        public Node(int x, int length) {
            this.x = x;
            this.length = length;
        }
    }

}
