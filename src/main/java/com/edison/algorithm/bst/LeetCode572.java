package com.edison.algorithm.bst;

import com.edison.algorithm.struct.TreeNode;

//判断是否是子树
public class LeetCode572 {

    public boolean isSubTree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {

        if (s == null && t == null) return true;
        if (s == null || t == null || s.val != t.val) return false;
        return check(s.left, t.left) && check(s.right, t.right);
    }
}
