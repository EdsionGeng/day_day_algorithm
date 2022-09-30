package com.edison.algorithm.offer;


import java.util.Arrays;
import java.util.List;

//序列化二叉树 实现序列化和反序列化
public class Offer37 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String serialize(TreeNode root) {
        return serHelper(root, new StringBuilder()).toString();
    }

    public StringBuilder serHelper(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("null,");
            return str;
        }
        str.append(root.val);
        str.append(",");
        serHelper(root.left, str);
        serHelper(root.right, str);
        return str;
    }

    public TreeNode deserialize(String data) {
        List<String> list = Arrays.asList(data.split(","));
        return deserialHelper(list);
    }

    public TreeNode deserialHelper(List<String> list) {
        if (list.get(0) == "null") {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = deserialHelper(list);
        root.right = deserialHelper(list);

        return root;
    }

    public static void main(String[] args) {
        Offer37 offer = new Offer37();

    }
}
