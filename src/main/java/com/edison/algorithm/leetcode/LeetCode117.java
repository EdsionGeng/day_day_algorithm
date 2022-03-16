package com.edison.algorithm.leetcode;

import java.util.LinkedList;

/**
 * 描述:
 * 填充每个节点的下一个右侧节点2
 *
 * @author gengyc
 * @create 2022-01-27 9:44
 */
public class LeetCode117 {
    static class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }

    public Node connect_1(Node root) {
        if (root == null) {
            return null;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.remove();
                if (size > 0) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = nextNode(root.next);
            }
        }
        if (root.right != null) {
            root.right.next = nextNode(root.next);
        }
        connect(root.left);
        connect(root.right);
        return root;
    }

    private Node nextNode(Node node) {
        while (node != null) {
            if (node.left != null) {
                return node.left;
            }
            if (node.right != null) {
                return node.right;
            }
            node = node.next;
        }
        return null;
    }
}