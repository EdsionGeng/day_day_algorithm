package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 恢复二叉搜索树
 *
 * @author gengyc
 * @create 2022-01-24 10:34
 */
public class LeetCode99 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    TreeNode t1, t2, pre;

    public void recoverTree(TreeNode root) {

    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (pre != null && pre.val > root.val) {
            if (t1 == null) t1 = pre;
            t2 = root;
        }
        pre = root;
        inorder(root.right);
    }
}