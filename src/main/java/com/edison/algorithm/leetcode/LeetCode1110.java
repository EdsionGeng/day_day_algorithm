package com.edison.algorithm.leetcode;

import com.edison.algorithm.struct.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//删除整数对应节点后 剩余的子树
public class LeetCode1110 {

    Set<Integer> toDeleteSet = new HashSet<>();
    List<TreeNode> forest = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] delete) {
        for (int i : delete
        ) {
            toDeleteSet.add(i);
        }
        addNodeToList(root);
        if (root != null && !toDeleteSet.contains(root.val)) {
            forest.add(root);
        }
        return forest;
    }

    private TreeNode addNodeToList(TreeNode root) {
        if (root == null) return null;
        root.left = addNodeToList(root.left);
        root.right = addNodeToList(root.right);
        if (toDeleteSet.contains(root.val)) {
            if (root.left != null) {
                forest.add(root.left);
            }
            if (root.right != null) {
                forest.add(root.right);
            }
            root = null;
        }

        return root;
    }

    public static void main(String[] args) {
        LeetCode1110 le = new LeetCode1110();
    }
}
