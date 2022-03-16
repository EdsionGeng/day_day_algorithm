package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 二叉树的锯齿形层次遍历
 *
 * @author gengyc
 * @create 2022-01-24 13:12
 */
public class LeetCode103 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traversal(root, res, 0);
        return res;
    }

    private void traversal(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        if ((level & 1) == 1) {
            res.get(level).add(0, root.val);
        } else {
            res.get(level).add(root.val);
        }
        traversal(root.left, res, level + 1);
        traversal(root.right, res, level + 1);
    }

    public static void main(String[] args) {

        int i = 1;
        System.out.println(i & 1);
        i = 97;
        System.out.println(i & 1);
    }
}