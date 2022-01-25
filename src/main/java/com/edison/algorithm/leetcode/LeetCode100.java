package com.edison.algorithm.leetcode;

/**
 * 描述:相同的树
 *
 * @author gengyc
 * @create 2022-01-24 10:49
 */
public class LeetCode100 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    //给定两个二叉树，编写一个函数来检验它们是否相同。
    //
    //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}