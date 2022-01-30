package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 二叉树最大路径和
 *
 * @author gengyc
 * @create 2022-01-27 17:31
 */
public class LeetCode124 {
    //给定一个非空二叉树，返回其最大路径和。
    //
    //本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
    //
    //示例 1:
    //
    //输入: [1,2,3]
    //输出: 6
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    private int ret = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return ret;
    }

    private int getMax(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, getMax(root.left));//如果子树路径和为负则应当置0表示最大路径不包含子树
        int right = Math.max(0, getMax(root.right));
        ret = Math.max(ret, left + right + root.val);//判断在该节点包含左右子树的路径和是否大于当前最大路径和
        return Math.max(left, right) + root.val;
    }


}