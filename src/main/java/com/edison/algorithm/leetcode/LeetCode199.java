package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 描述:
 * 二叉树的右视图
 *
 * @author gengyc
 * @create 2022-03-01 14:58
 */
public class LeetCode199 {
    //给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
//示例:
//
//输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                count--;
                TreeNode cur = queue.poll();
                if (count == 0) {
                    res.add(cur.val);
                }
                if (cur.left != null) {
                    ((LinkedList<TreeNode>) queue).add(cur.left);
                }
                if (cur.right != null) {
                    ((LinkedList<TreeNode>) queue).add(cur.right);
                }
            }
        }
        return res;
    }

    int[] max = {0};

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root, 1);
        return res;
    }

    private void helper(List<Integer> res, TreeNode treeNode, int deep) {
        if (treeNode == null) return;
        if (deep > max[0]) {
            max[0] = deep;
            res.add(treeNode.val);
        }
        helper(res, treeNode.right, deep + 1);
        helper(res, treeNode.left, deep + 1);
    }

    public static void main(String[] args) {
        LeetCode199 le = new LeetCode199();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<Integer> res = le.rightSideView(root);
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}