package com.edison.algorithm.struct.graph;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 描述:
 * 邻接表
 * 前面的邻接矩阵方法实际上是图的一种静态存储方法。建立这种存储结构时需要预先知道图中顶点的个数。
 * 如果图结构本身需要在解决问题的过程中动态地产生，则每增加或者删除一个顶点都需要改变邻接矩阵的大小，
 * 显然这样做的效率很低。除此之外，邻接矩阵所占用的存储单元数目至于图中的顶点的个数有关，而与边或弧的数目无关，
 * 若图是一个稀疏图的话，必然造成存储空间的浪费。邻接表很好地解决了这些问题。
 * 邻接表的存储方式是一种顺序存储与链式存储相结合的存储方式，顺序存储部分用来保存图中的顶点信息，
 * 链式存储部分用来保存图中边或弧的信息。具体的做法是，使用一个一维数组保存图中顶点的信息，数组中每个数组元素包含两个域。
 *
 * @author gengyongchang
 * @create 2020-08-15 14:05
 */
public class GraphAdjList<E> implements IGraph<E> {

    /**
     * 邻接单链表中的每个结点表示依附于该结点的一条边，称作边结点，边结点的数据结构如下：
     */
    private static class ENode {
        /**
         * 邻接顶点序号
         */
        int adjVex;
        /**
         * 存储边或弧相关信息 如权值
         */
        int weight;
        /**
         * 下一个邻接表节点
         */
        ENode nextAdj;

        public ENode(int adjVex, int weight) {
            this.adjVex = adjVex;
            this.weight = weight;
        }
    }

    /**
     * 数组中每个数组元素包含两个域。其存储结构如下：
     *
     * @param <E>
     */
    private static class VNode<E> {
        /**
         * 顶点信息
         */
        E data;
        /**
         * 邻接表第一个节点 头指针域
         */
        ENode firstAdj;
    }

    /**
     * 存储图顶点的一维数组
     */
    private VNode<E>[] vexs;

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

    public GraphAdjList(int maxNumOfVexs) {
        this.maxNumOfVexs = maxNumOfVexs;
        vexs = (VNode<E>[]) Array.newInstance(VNode.class, maxNumOfVexs);
    }

    @Override
    public int getNumberOfVertex() {
        return numOfVexs;
    }

    @Override
    public boolean insertVex(E v) {
        if (numOfVexs >= maxNumOfVexs) {
            return false;
        }
        VNode<E> vNode = new VNode<>();
        vNode.data = v;
        vexs[numOfVexs++] = vNode;
        return true;
    }

    @Override
    public boolean deleteVex(E v) {
        for (int i = 0; i < numOfVexs; i++) {
            if (vexs[i].equals(v)) {
                for (int j = 0; j < numOfVexs - 1; j++) {
                    vexs[j] = vexs[j + 1];
                }
                vexs[numOfVexs - 1] = null;
                ENode current;
                ENode previous;
                for (int j = 0; j < numOfVexs; j++) {
                    if (vexs[j].firstAdj == null) {
                        continue;
                    }
                    if (vexs[j].firstAdj.adjVex == i) {
                        vexs[j].firstAdj = null;
                        continue;
                    }
                    current = vexs[j].firstAdj;
                    while (current != null) {
                        previous = current;
                        current = current.nextAdj;
                        if (current != null && current.adjVex == i) {
                            previous.nextAdj = current.nextAdj;

                            break;
                        }
                    }
                }
                for (int j = 0; j < numOfVexs; j++) {
                    current = vexs[j].firstAdj;
                    while (current != null) {
                        if (current.adjVex > i) {
                            current.adjVex--;
                        }
                        current = current.nextAdj;
                    }
                }
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
            throw new ArrayIndexOutOfBoundsException();
        }
        return vexs[v].data;
    }

    @Override
    public boolean insertEdge(int v1, int v2, int weight) {
        if (v1 < 0 || v2 < 0 || v1 >= numOfVexs || v2 >= numOfVexs) {
            throw new IndexOutOfBoundsException();
        }
        ENode vex1 = new ENode(v2, weight);
        // 索引为index1的顶点没有邻接顶点
        if (vexs[v1].firstAdj == null) {
            vexs[v1].firstAdj = vex1;
        }// 索引为index1的顶点没有邻接顶点
        else {
            vex1.nextAdj = vexs[v1].firstAdj;
            vexs[v1].firstAdj = vex1;
        }

        ENode vex2 = new ENode(v1, weight);
        if (vexs[v2].firstAdj == null) {
            vexs[v2].firstAdj = vex2;
        } else {
            vex2.nextAdj = vexs[v2].firstAdj;
            vexs[v2].firstAdj = vex2;
        }
        return true;
    }

    @Override
    public boolean deleteEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 >= numOfVexs || v2 >= numOfVexs) {
            throw new ArrayIndexOutOfBoundsException();
        }
        // 删除索引为index1的顶点与索引为index2的顶点之间的边
        ENode current = vexs[v1].firstAdj;
        ENode previous = null;
        while (current != null && current.adjVex != v2) {
            previous = current;
            current = current.nextAdj;
        }
        if (current != null) {
            previous.nextAdj = current.nextAdj;
        }
        current = vexs[v2].firstAdj;
        while (current != null && current.adjVex != v1) {
            previous = current;
            current = current.nextAdj;
        }
        if (current != null) {
            previous.nextAdj = current.nextAdj;
        }
        return true;
    }

    @Override
    public int getEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 >= numOfVexs || v2 >= numOfVexs) {
            throw new ArrayIndexOutOfBoundsException();
        }
        ENode current = vexs[v1].firstAdj;
        while (current != null) {
            if (current.adjVex == v2) {
                return current.weight;
            }
            current = current.nextAdj;
        }
        return 0;
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
        ENode current;
        while (!stack.isEmpty()) {
            v = stack.pop();
            sb.append(vexs[v].data + " ,");
            current = vexs[v].firstAdj;
            while (current != null) {
                if (!visited[current.adjVex]) {
                    stack.push(current.adjVex);
                    visited[current.adjVex] = true;
                }
                current = current.nextAdj;
            }

        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : null;
    }

    @Override
    public String breadFirstSearch(int v) {
        if (v < 0 || v >= numOfVexs) {
            throw new ArrayIndexOutOfBoundsException();
        }
        visited = new boolean[numOfVexs];
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;
        ENode current;
        while (!queue.isEmpty()) {
            v = queue.poll();
            sb.append(vexs[v].data + " ,");
            current = vexs[v].firstAdj;
            while (current != null) {
                if (!visited[current.adjVex]) {
                    queue.offer(current.adjVex);
                    visited[current.adjVex] = true;
                }
                current = current.nextAdj;
            }

        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : null;
    }

    @Override
    public int[] dijkstra(int v) {
        return new int[0];
    }
}