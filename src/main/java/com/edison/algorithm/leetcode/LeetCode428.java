package com.edison.algorithm.leetcode;

//序列化和反序列化  N叉树

import java.util.*;

public class LeetCode428 {


    static class Node {
        public int val;
        public List<Node> children;

        public Node(int val, ArrayList<Node> children) {
            this.val = val;
            this.children = children;
        }

        public Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    public String serialize(Node root) {
        if (root == null) return "";
        StringBuffer sb = new StringBuffer();
        sb.append(root.val);
        List<Node> children = root.children;
        if (!children.isEmpty()) {
            sb.append(' ');
            sb.append('(');
            for (Node child : children) {
                sb.append(' ');
                sb.append(serialize(child));
            }
            sb.append(' ');
            sb.append(')');
        }
        return sb.toString();

    }

    public Node deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(" ");
        Node root = new Node(Integer.parseInt(arr[0]), new ArrayList<>());
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals("(")) {
                continue;
            } else if (arr[i].equals(")")) {
                stack.pop();
            } else {
                if (!arr[i - 1].equals("(")) {
                    stack.pop();
                }
                Node node = new Node(Integer.parseInt(arr[i]));
                stack.peek().children.add(node);
                stack.push(node);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        LeetCode428 le = new LeetCode428();
        ArrayList<Node> children = new ArrayList<>();
        children.add(new Node(2));
        children.add(new Node(3));
        children.add(new Node(4));
        children.get(0).children.add(new Node(5));
        children.get(0).children.add(new Node(6));
        Node root = new Node(1, children);
        String res = le.serialize(root);
        Node result = le.deserialize(res);

    }
}
