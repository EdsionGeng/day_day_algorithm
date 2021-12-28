package com.edison.algorithm.algorithm;

import java.util.*;

/**
 * 描述:
 * 哈夫曼编码
 * 霍夫曼编码是一种无前缀编码。解码时不会混淆。其主要应用在数据压缩，加密解密等场合。
 * 如果考虑到进一步节省存储空间，就应该将出现概率大（占比多）的字符用尽量少的0-1进行编码，也就是更靠近根（节点少），
 * 这也就是最优二叉树-哈夫曼树。
 *
 * @author gengyongchang
 * @create 2020-04-23 14:19
 */
public class Huffman {
    public static class Node {
        int value;
        Node left;
        Node right;
        int deep;

        public Node(int value) {
            this.value = value;
            this.deep = 0;
        }

        public Node(Node n1, Node n2, int value) {
            this.left = n1;
            this.right = n2;
            this.value = value;
        }
    }

    private Node root;
    private List<Node> nodes;

    public Huffman() {
        this.nodes = null;
    }

    public Huffman(List<Node> list) {
        this.nodes = list;
    }

    public void createTree() {
        Queue<Node> q1 = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        });
        q1.addAll(nodes);
        while (!q1.isEmpty()) {
            Node n1 = q1.poll();
            Node n2 = q1.poll();
            Node parent = new Node(n1, n2, n1.value + n2.value);
            if (q1.isEmpty()) {
                root = parent;
                return;
            }
            q1.add(parent);
        }
    }

    public int getWeight() {
        Queue<Node> q1 = new ArrayDeque<>();
        q1.add(root);
        int weight = 0;
        while (!q1.isEmpty()) {
            Node va = q1.poll();
            if (va.left != null) {
                va.left.deep = va.deep + 1;
                va.right.deep = va.deep + 1;
                q1.add(va.left);
                q1.add(va.right);
            } else {
                weight += va.deep * va.value;
            }
        }
        return weight;
    }
    public static void main(String[] args) {
        List<Node>list=new ArrayList<>();
        list.add(new Node(2));
        list.add(new Node(3));
        list.add(new Node(6));
        list.add(new Node(8));
        list.add(new Node(9));
        Huffman tree=new Huffman();
        tree.nodes=list;
        tree.createTree();
        System.out.println(tree.getWeight());
    }
}