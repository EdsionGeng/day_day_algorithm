package com.edison.algorithm.algorithm;

/**
 * @Description TODO
 * @Date 2020/7/28下午11:05
 * @Created by edsiongeng
 */
public class Dijkstra {

    /*
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

    public static void main(String[] args) {
        Dijkstra test = new Dijkstra();
        int[][] adjMatrix = {{0, 6, 3, -1, -1, -1},
                {6, 0, 2, 5, -1, -1},
                {3, 2, 0, 3, 4, -1},
                {-1, 5, 3, 0, 2, 3},
                {-1, -1, 4, 2, 0, 5},
                {-1, -1, -1, 3, 5, 0}};
        int[] result = test.getShortestPaths(adjMatrix);
        System.out.println("顶点0到图中所有顶点之间的最短距离为：");
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
    }


}
