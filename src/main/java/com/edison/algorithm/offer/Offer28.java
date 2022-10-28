package com.edison.algorithm.offer;

//对称二叉树
public class Offer28 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }
}
