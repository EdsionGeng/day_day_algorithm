package com.edison.algorithm.offer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

//二叉树和为某一值路径
public class Offer34 {
    static class TreeNode {
        private int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) return new ArrayList<>();
        if (root.val == target && root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            result.add(list);
        }
        List<List<Integer>> left = pathSum(root.left, target - root.val);
        List<List<Integer>> right = pathSum(root.right, target - root.val);
        for (List<Integer> list : left) {
            list.add(0, root.val);
            result.add(list);
        }
        for (List<Integer> list : right) {
            list.add(0, root.val);
            result.add(list);
        }
        return result;
    }


}
