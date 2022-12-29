package com.edison.algorithm.leetcode;

//二叉搜索树转换为累加树

import com.edison.algorithm.struct.TreeNode;

public class LeetCode538 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
