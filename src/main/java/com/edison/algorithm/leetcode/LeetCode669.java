package com.edison.algorithm.leetcode;

import com.edison.algorithm.struct.TreeNode;

//修剪二叉树 ，使其范围在[L,R]
public class LeetCode669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
}
