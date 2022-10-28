package com.edison.algorithm.offer;


import org.apache.commons.collections4.map.LinkedMap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//序列化二叉树 实现序列化和反序列化
public class Offer37 {
    public static class TreeNode {
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
        List<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialHelper(list);
    }

    public TreeNode deserialHelper(List<String> list) {
        if (list.get(0).equals("null")) {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        String str = offer.serialize(root);
        offer.deserialize(str);

    }
}
