package com.edison.algorithm.offer;

//二叉树镜像
public class Offer27 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    }

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) return null;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
