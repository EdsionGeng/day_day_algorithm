package com.edison.algorithm.bst;

import com.edison.algorithm.struct.TreeNode;

//合并两个二叉树
public class LeetCode617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) {

            return root2;
        }
        if (root2 == null) {

            return root1;
        }
        TreeNode merged = new TreeNode(root1.val + root2.val);

        merged.left = mergeTrees(root1.left, root2.left);
        merged.right = mergeTrees(root1.right, root2.right);
        return merged;
    }

    public static void main(String[] args) {
        LeetCode617 le = new LeetCode617();
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        TreeNode root = le.mergeTrees(root1, root2);
    }
}
