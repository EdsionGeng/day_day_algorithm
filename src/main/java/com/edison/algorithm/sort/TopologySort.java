package com.edison.algorithm.sort;

import java.util.*;

/**
 * 描述:
 * 拓扑排序
 *
 * @author gengyongchang
 * @create 2020-08-12 13:11
 */
public class TopologySort {
    private static class Node {
        public Object val;
        public int pathIn = 0;

        public Node(Object val) {
            this.val = val;
        }
    }

    private static class Graph {
        public Set<Node> vertexSet = new HashSet<>();
        public Map<Node, Set<Node>> adjNode = new HashMap<>();

        /**
         * 步骤：1.不包括首尾节点，添加
         * 2.已包含节点返回不操作
         *
         * @param start
         * @param end
         * @return
         */
        public boolean addNode(Node start, Node end) {
            if (!vertexSet.contains(start)) {
                vertexSet.add(start);
            }
            if (!vertexSet.contains(end)) {
                vertexSet.add(end);
            }
            if (adjNode.containsKey(start) && adjNode.get(start).contains(end)) {
                return false;
            }
            if (adjNode.containsKey(start)) {
                adjNode.get(start).add(end);
            } else {
                Set<Node> temp = new HashSet<>();
                temp.add(end);
                adjNode.put(start, temp);
            }
            end.pathIn++;
            return true;
        }
    }

    private static class KahnTopo {
        private List<Node> result;
        private Queue<Node> setOfZeroIndegree;
        private Graph graph;

        public KahnTopo(Graph di) {
            this.graph = di;
            this.result = new ArrayList<>();
            this.setOfZeroIndegree = new LinkedList<>();
            //
            for (Node iterator : this.graph.vertexSet) {
                if (iterator.pathIn == 0) {
                    setOfZeroIndegree.add(iterator);
                }
            }
        }

        private void process() {
            while (!setOfZeroIndegree.isEmpty()) {
                Node v = setOfZeroIndegree.poll();
                result.add(v);
                if (this.graph.adjNode.keySet().isEmpty()) {
                    return;
                }
                for (Node w : this.graph.adjNode.get(v)) {
                    w.pathIn--;
                    if (w.pathIn == 0) {
                        setOfZeroIndegree.add(w);
                    }
                }
                this.graph.vertexSet.remove(v);
                this.graph.adjNode.remove(v);
            }
            // 如果此时图中还存在边，那么说明图中含有环路
            if (!this.graph.vertexSet.isEmpty()) {
                throw new IllegalArgumentException("Has Cycle !");
            }

        }
        //结果集
        public Iterable<Node> getResult() {
            return result;
        }
    }
    //测试
    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");

        Graph graph = new Graph();

        graph.addNode(B, C);
        graph.addNode(B, D);
        graph.addNode(D, C);
        graph.addNode(E, C);
        graph.addNode(A, B);
        graph.addNode(C, F);

        KahnTopo topo = new KahnTopo(graph);
        topo.process();
        for(Node temp : topo.getResult()){
            System.out.print(temp.val.toString() + "-->");
        }
    }
}