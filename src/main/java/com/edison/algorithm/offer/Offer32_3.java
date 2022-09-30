package com.edison.algorithm.offer;

import java.util.*;

//从上到下打印二叉树3
public class Offer32_3 {
    static class TreeNode {
        private int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int count = queue.size();
            Deque<Integer> levelList = new LinkedList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                if (flag) {
                    levelList.offerLast(node.val);
                } else {
                    levelList.offerFirst(node.val);
                }

                if (node.left != null) queue.add(node.right);
                if (node.right != null) queue.add(node.left);
                count--;
            }
            flag = !flag;
            ans.add(new ArrayList<>(levelList));

        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        levelOrder(root);
    }
}
