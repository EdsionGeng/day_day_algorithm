package com.edison.algorithm.leetcode;


import java.util.ArrayList;
import java.util.List;

//最大二叉树
public class LeetCode654 {
    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode construct2(int[] nums) {
        int n = nums.length;
        List<Integer> stack = new ArrayList<>();
        TreeNode[] tree = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new TreeNode(nums[i]);
            while (!stack.isEmpty() && nums[i] > nums[stack.get(stack.size() - 1)]) {
                tree[i].left = tree[stack.get(stack.size() - 1)];
                stack.remove(stack.size() - 1);
            }
            if (!stack.isEmpty()) {
                tree[stack.get(stack.size() - 1)].right = tree[i];
            }
            stack.add(i);

        }
        return tree[stack.get(0)];
    }

//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        if (nums.length == 0) return null;
//        int max = 0, index = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > max) {
//                max = nums[i];
//                index = i;
//            }
//        }
//        int[] leftNums = new int[index];
//        int[] rightNums = new int[nums.length - index - 1];
//        for (int i = 0; i < index; i++) {
//            leftNums[i] = nums[i];
//        }
//        for (int i = 0, j = index + 1; j < nums.length; i++, j++) {
//            rightNums[i] = nums[j];
//        }
//        TreeNode root = new TreeNode(max);
//        if (leftNums.length != 0) {
//            root.left = constructMaximumBinaryTree(leftNums);
//        }
//        if (rightNums.length != 0) {
//            root.right = constructMaximumBinaryTree(rightNums);
//        }
//        return root;
//    }

    public TreeNode construct(int[] nums, int left, int right) {
        if (left > right) return null;
        int index = left;
        for (int i = left + 1; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = construct(nums, left, index - 1);
        root.right = construct(nums, index + 1, right);
        return root;
    }

    public static void main(String[] args) {
        LeetCode654 le = new LeetCode654();
        //TreeNode root = le.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        //System.out.println(root.val);

    }
}
