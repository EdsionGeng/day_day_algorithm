package com.edison.algorithm.offer;

//二叉搜索树第K大节点
public class Offer54 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int k;
    int res;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null || k == 0) return;
        dfs(root.right);
        if (--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }
}
