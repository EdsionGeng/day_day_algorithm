package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 二叉树所有路径
 * @Date 2022/4/7下午4:37
 * @Created by edsiongeng
 */
public class LeetCode257 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        String path = new String("");
        List<String> list = new ArrayList<>();
        helper(root, path, list);
        return list;
    }

    public void helper(TreeNode root, String path, List<String> list) {
        if (root == null) {
            return;
        }
        path += root.val;
        if (root.left == null && root.right == null) {
            list.add(path);
        } else {
            path += "-> ";
            helper(root.left, path, list);
            helper(root.right, path, list);
        }
    }
}
