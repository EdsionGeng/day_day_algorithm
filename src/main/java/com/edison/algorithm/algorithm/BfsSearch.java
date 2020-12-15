package com.edison.algorithm.algorithm;

import java.util.*;

/**
 * @Description TODO
 * @Date 2020/7/15下午11:34
 * @Created by edsiongeng
 */
public class BfsSearch {

    public static void main(String[] args) {
        BfsSearch bfsSearch = new BfsSearch();
        bfsSearch.bfsSearch(bfsSearch.init());
    }

    public void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();//存储访问的节点
        Queue<Node> visited = new LinkedList<>();// /存储访问过的节点

        queue.offer(start);
        visited.offer(start);

        while (!queue.isEmpty()) {
            Node node = queue.poll();//队列头节点出队
            visit(node);

            Set<Node> set = node.getSet();//获取所有直接关联节点

            Iterator<Node> iterator = set.iterator();
            while (iterator.hasNext()) {
                Node next = iterator.next();
                if (!visited.contains(next)) {
                    queue.offer(next);
                    visited.offer(next);
                }
            }
        }
    }


    public Node init() {//初始化一个图
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        nodeA.getSet().add(nodeB);
        nodeA.getSet().add(nodeC);
        nodeB.getSet().add(nodeD);
        nodeB.getSet().add(nodeE);
        nodeC.getSet().add(nodeF);
        nodeC.getSet().add(nodeG);
        nodeD.getSet().add(nodeH);
        nodeE.getSet().add(nodeH);
        return nodeA;
    }

    public void visit(Node node) {//访问每个节点

        System.out.println(node.getName());

    }

    public void bfsSearch(Node start) {

        Queue<Node> queue = new LinkedList();
        Queue<Node> visited = new LinkedList();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visit(node);
            Set<Node> set = node.getSet();
            Iterator<Node> iterator = set.iterator();
            while (iterator.hasNext()) {
                Node node1 = iterator.next();
                if (!visited.contains(node1)) {
                    queue.add(node1);
                    visited.add(node1);
                }
            }
        }

    }


    public static class Node implements Comparable<Node> {
        private String name;
        private TreeSet<Node> set = new TreeSet<>();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Node() {

        }

        public TreeSet<Node> getSet() {
            return set;
        }

        public void setSet(TreeSet<Node> set) {
            this.set = set;
        }

        public Node(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Node o) {
            if (name.hashCode() > o.getName().hashCode()) {
                return 1;
            }
            return 0;
        }
    }
}
