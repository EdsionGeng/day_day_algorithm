package com.edison.algorithm.bst;

import com.edison.algorithm.struct.TreeNode;

//翻转二叉树
public class LeetCode226 {


    public TreeNode invertTree(TreeNode root) {

        if (root == null) return root;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        LeetCode226 le = new LeetCode226();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        le.invertTree(root);
    }
}
