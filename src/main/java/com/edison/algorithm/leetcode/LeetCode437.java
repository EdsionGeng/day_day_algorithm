package com.edison.algorithm.leetcode;

import com.edison.algorithm.struct.TreeNode;

//二叉树路径和等于目标值
public class LeetCode437 {


    int pathSum(TreeNode root, int sum) {
        return root != null ? pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum) : 0;
    }

    int pathSumStartWithRoot(TreeNode root, int sum) {
        if (root == null) return 0;
        int count = root.val == sum ? 1 : 0;
        count += pathSumStartWithRoot(root.left, sum - root.val);
        count += pathSumStartWithRoot(root.right, sum - root.val);
        return count;
    }
}
