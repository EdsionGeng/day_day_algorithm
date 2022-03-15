package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 完全二叉树节点个数
 *
 * @author gengyc
 * @create 2022-03-15 16:32
 */
public class LeetCode222 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ld = getDepth(root.left);
        int rd = getDepth(root.right);
        if (ld == rd) {
            return (1 << ld) + countNodes(root.right);
        } else {
            return (1 << rd) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode r) {
        int depth = 0;
        while (r != null) {
            depth++;
            r = r.left;
        }
        return depth;
    }

    public static void main(String[] args) {
        LeetCode222 le = new LeetCode222();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(le.countNodes(root));
    }
}