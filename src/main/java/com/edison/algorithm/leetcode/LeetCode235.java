package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 二叉搜索树最近公共祖先
 *
 * @author gengyc
 * @create 2022-03-25 18:14
 */
public class LeetCode235 {

    TreeNode res = null;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root, p, q);
        return res;
    }

    public void lca(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val - p.val) * (root.val - q.val) <= 0) {
            res = root;
        } else if (root.val < p.val && root.val < q.val) {
            lca(root.right, p, q);
        } else {
            lca(root.left, p, q);
        }
    }

}