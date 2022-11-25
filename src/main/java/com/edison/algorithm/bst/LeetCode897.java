package com.edison.algorithm.bst;

import com.edison.algorithm.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

//递增顺序搜索树
public class LeetCode897 {

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode curNode = dummyNode;
        for (int value : res) {
            curNode.right = new TreeNode(value);
            curNode = curNode.right;
        }
        return dummyNode.right;

    }

    public void inorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);

    }
}
