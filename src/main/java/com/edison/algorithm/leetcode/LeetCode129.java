package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 求根到叶子节点数字之和
 *
 * @author gengyc
 * @create 2022-01-28 16:48
 */
public class LeetCode129 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    static int sum;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        childSum(0, root);
        return sum;
    }

    public static void childSum(int val, TreeNode root) {
        if (root == null) return;
        int k = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += k;
        }
        childSum(k, root.left);
        childSum(k, root.right);
    }

}