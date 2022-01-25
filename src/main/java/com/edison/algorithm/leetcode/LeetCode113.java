package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 路径总和2
 *
 * @author gengyc
 * @create 2022-01-25 15:57
 */
public class LeetCode113 {
    //给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
//说明: 叶子节点是指没有子节点的节点。
//
//示例:
//给定如下二叉树，以及目标和 sum = 22，返回:
//[[5,4,11,2],[5,8,4,5]]
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root.val == sum && root.left == null && root.right == null) {
            List<Integer> arr = new ArrayList<>();
            arr.add(root.val);
            ans.add(arr);
        }
        List<List<Integer>> left = pathSum(root.left, sum - root.val);
        List<List<Integer>> right = pathSum(root.right, sum - root.val);
        for (List<Integer> list : left) {
            list.add(0, root.val);
            ans.add(list);
        }
        for (List<Integer> list : right) {
            list.add(0, root.val);
            ans.add(list);
        }
        return ans;
    }
}