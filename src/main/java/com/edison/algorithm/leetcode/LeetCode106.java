package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 从中序后序遍历构建二叉树
 *
 * @author gengyc
 * @create 2022-01-24 15:22
 */
public class LeetCode106 {
    //根据一棵树的中序遍历与后序遍历构造二叉树。
//
//注意:
//你可以假设树中没有重复的元素。
//
//例如，给出
//
//中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int postEnd, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int currentVal = postorder[postEnd];
        TreeNode current = new TreeNode(currentVal);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == currentVal) {
                inIndex = i;
            }
        }
        TreeNode left = helper(inorder, postorder, postEnd - (inEnd - inIndex) - 1, inStart, inIndex - 1);
        TreeNode right = helper(inorder, postorder, postEnd - 1, inIndex + 1, inEnd);
        current.left = left;
        current.right = right;
        return current;
    }

}