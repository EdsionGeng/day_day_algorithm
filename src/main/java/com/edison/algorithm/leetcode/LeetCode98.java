package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 验证二叉搜索树
 *
 * @author gengyc
 * @create 2022-01-24 10:19
 */
public class LeetCode98 {
    //给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
//假设一个二叉搜索树具有如下特征：
//
//节点的左子树只包含小于当前节点的数。
//节点的右子树只包含大于当前节点的数。
//所有左子树和右子树自身必须也是二叉搜索树。
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    double last = -Double.MAX_VALUE;

    public boolean isVaildBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isVaildBST(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isVaildBST(root.right);
            }
        }
        return false;
    }
}