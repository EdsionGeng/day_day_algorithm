package com.edison.algorithm.offer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//从上到下打印二叉树
public class Offer32_1 {
    static class TreeNode {
        private int val;
        TreeNode left;
        TreeNode right;
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
             r[i]=res.get(i);
        }
        return r;
    }
}
