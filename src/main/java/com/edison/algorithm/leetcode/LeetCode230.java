package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 二叉树第k小的元素
 *
 * @author gengyc
 * @create 2022-03-25 15:49
 */
public class LeetCode230 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res = 0;
    int n = 0;

    public void help(TreeNode root, int k) {
        if (root == null || n > k) return;
        help(root.left, k);
        n++;
        if (n == k) {
            res = root.val;
        }
        help(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        help(root, k);
        return res;
    }

}