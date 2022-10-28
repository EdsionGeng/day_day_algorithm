package com.edison.algorithm.offer;

//二叉搜索树最近公共祖先
public class Offer68 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if ((p.val < ancestor.val && q.val < ancestor.val)) {
                ancestor = ancestor.left;
            } else if ((p.val > ancestor.val && q.val > ancestor.val)) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;

    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;

    }
}
