package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 克隆图
 *
 * @author gengyc
 * @create 2022-01-29 15:03
 */
public class LeetCode133 {
    //给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
//
//图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            this.val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> neighbors) {
            this.val = _val;
            this.neighbors = neighbors;

        }
    }

    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node copy = new Node(node.val, new ArrayList<>());
        map.put(node, copy);
        for (Node neighbor : node.neighbors) {
            if (map.containsKey(neighbor)) {
                copy.neighbors.add(map.get(neighbor));
            } else {
                copy.neighbors.add(cloneGraph(neighbor));
            }
        }
        return copy;
    }
}