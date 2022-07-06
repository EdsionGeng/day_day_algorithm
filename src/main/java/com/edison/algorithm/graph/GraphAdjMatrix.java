package com.edison.algorithm.graph;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 描述:
 * 邻接矩阵
 * 邻接矩阵是用两个数组来表示图，一个数组是一维数组，存储图中的顶点信息；一个数组是二维数组，即矩阵，
 * 存储顶点之间相邻的信息，也就是边或弧的信息。如果图中有n个顶点，就需要n×n的二维数组来表示图。
 * <p>
 * 如果图的边没有权值，用0表示顶点之间无边，用1表示顶点之间有边。
 * 如果图的弧有权值，用无穷大表示顶点之间无边，用权值表示顶点之间有边，同一点之间的权值为0。
 * 注意：如果图为稀疏图的话，在用邻接矩阵表示图的时候，由于在表示边的时候会导致变成一个系数矩阵，
 * 导致很多的浪费。所以，应在图为稠密图的时候使用邻接矩阵实现图。
 *
 * @author gengyongchang
 * @create 2020-08-15 13:16
 */
public class GraphAdjMatrix<E> implements IGraph<E> {
    /**
     * 存储图顶点的一维数组
     */
    private E[] vexs;
    /**
     * 存储图的边二维数组
     */
    private int[][] edges;
    /**
     * 顶点实际数量
     */
    private int numOfVexs;
    /**
     * 顶点的最大数量
     */
    private int maxNumOfVexs;
    /**
     * 判断顶点是否被访问过
     */
    private boolean[] visited;

    public GraphAdjMatrix(int maxNumOfVexs, Class<E> type) {
        this.maxNumOfVexs = maxNumOfVexs;
        edges = new int[maxNumOfVexs][maxNumOfVexs];
        vexs = (E[]) Array.newInstance(type, maxNumOfVexs);
    }

    @Override
    public int getNumberOfVertex() {
        return maxNumOfVexs;
    }

    @Override
    public boolean insertVex(E v) {
        if (numOfVexs >= maxNumOfVexs) {
            return false;
        }
        vexs[numOfVexs++] = v;
        return true;
    }

    /**
     * 删除顶点
     *
     * @param v
     * @return
     */
    @Override
    public boolean deleteVex(E v) {
        for (int i = 0; i < numOfVexs; i++) {
            if (vexs[i].equals(v)) {
                for (int j = i; j < numOfVexs - 1; j++) {
                    vexs[j] = vexs[j + 1];
                }
                vexs[numOfVexs - 1] = null;
                // TODO
                for (int col = i; col < numOfVexs - 1; col++) {
                    for (int row = 0; row < numOfVexs; row++) {
                        edges[col][row] = edges[col + 1][row];
                    }
                }
                for (int row = i; row < numOfVexs - 1; row++) {
                    for (int col = 0; col < numOfVexs; col++) {
                        edges[col][row] = edges[col][row + 1];
                    }
                }
                numOfVexs--;
                return true;
            }

        }
        return false;
    }

    @Override
    public int indexOfVex(E v) {
        for (int i = 0; i < numOfVexs; i++) {
            if (vexs[i].equals(v)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E valueOfVex(int v) {
        if (v < 0 || v > numOfVexs) {
            return null;
        }
        return vexs[v];
    }

    @Override
    public boolean insertEdge(int v1, int v2, int weight) {
        if (v1 < 0 || v1 >= numOfVexs || v2 < 0 || v2 >= numOfVexs) {
            throw new IndexOutOfBoundsException();
        }
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        return true;
    }

    @Override
    public boolean deleteEdge(int v1, int v2) {
        if (v1 < 0 || v1 >= numOfVexs || v2 < 0 || v2 >= numOfVexs) {
            throw new IndexOutOfBoundsException();
        }
        edges[v1][v2] = 0;
        edges[v2][v1] = 0;
        return true;
    }

    @Override
    public int getEdge(int v1, int v2) {
        if (v1 < 0 || v1 >= numOfVexs || v2 < 0 || v2 >= numOfVexs) {
            throw new IndexOutOfBoundsException();
        }
        return edges[v1][v2];
    }

    @Override
    public String depthFirstSearch(int v) {
        if (v < 0 || v >= numOfVexs) {
            throw new ArrayIndexOutOfBoundsException();
        }
        visited = new boolean[numOfVexs];
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;
        while (!stack.isEmpty()) {
            v = stack.pop();
            sb.append(vexs[v] + ",");
            for (int i = numOfVexs - 1; i >= 0; i--) {
                if (edges[v][i] != 0 && edges[v][i] != Integer.MAX_VALUE && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : null;
    }

    @Override
    public String breadFirstSearch(int v) {
        if (v < 0 || v >= numOfVexs) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Queue<Integer> queue = new LinkedList();
        StringBuilder sb = new StringBuilder();
        visited = new boolean[numOfVexs];
        queue.offer(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            v = queue.poll();
            sb.append(vexs[v] + " ,");
            for (int i = 0; i < numOfVexs; i++) {
                if (edges[v][i] != 0 && edges[v][i] != Integer.MAX_VALUE && !visited[v]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : null;
    }

    @Override
    public int[] dijkstra(int v) {
        return new int[0];
    }
}