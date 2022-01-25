package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 从前序与中序遍历序列构造二叉树
 *
 * @author gengyc
 * @create 2022-01-24 14:06
 */
public class LeetCode105 {
    //根据一棵树的前序遍历与中序遍历构造二叉树。
//
//注意:
//你可以假设树中没有重复的元素。
//
//例如，给出
//
//前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
    private int pre = 0;
    private int in = 0;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, Integer.MAX_VALUE + 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, long stop) {
        if (pre == preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int val = preorder[pre++];
        TreeNode root = new TreeNode(val);
        root.left = buildTree(preorder, inorder, val);
        root.right = buildTree(preorder, inorder, stop);
        return root;
    }

    public static void main(String[] args) {
        LeetCode105 le = new LeetCode105();
        le.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}