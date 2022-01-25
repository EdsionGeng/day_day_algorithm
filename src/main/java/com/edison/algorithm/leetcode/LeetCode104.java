package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 二叉树最大深度
 *
 * @author gengyc
 * @create 2022-01-24 13:55
 */
public class LeetCode104 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}