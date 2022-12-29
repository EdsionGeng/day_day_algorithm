package com.edison.algorithm.leetcode;

import com.edison.algorithm.struct.TreeNode;

//找树左下角的值
public class LeetCode513 {
    int curVal = 0;
    int curHeight = 0;

    public int findBottomLeftValue(TreeNode root) {
        int curHeight = 0;
        dfs(root, 0);
        return curVal;

    }

    public void dfs(TreeNode root, int height) {
        if (root == null) return;
        height++;
        dfs(root.left, height);
        dfs(root.right, height);
        if (height > curHeight) {
            curHeight = height;
            curVal = root.val;
        }
    }
}
