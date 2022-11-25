package com.edison.algorithm.leetcode;

import com.edison.algorithm.struct.TreeNode;

//二叉树最长直径
public class LeetCode543 {

    int ans;

    int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        helper(root);
        return ans-1;
    }

    int helper(TreeNode node) {
        if (node == null) return 0;
        int l = helper(node.left), r = helper(node.right);
        ans = Math.max(l + r + 1, ans);
        return Math.max(l, r) + 1;

    }

    public static void main(String[] args) {
        LeetCode543 le = new LeetCode543();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(le.diameterOfBinaryTree(root));
    }

}
