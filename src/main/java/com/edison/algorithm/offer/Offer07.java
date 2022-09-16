package com.edison.algorithm.offer;


import java.util.HashMap;

public class Offer07 {
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
    //前序遍历 根 左 右
    //中序遍历 左 根 右

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);

    }

    TreeNode recur(int root, int left, int right) {
        if (left > right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        int inIndex = dic.get(preorder[root]);
        node.left = recur(root + 1, left, inIndex - 1);
        node.right = recur(root + inIndex - left + 1, inIndex + 1, right);
        return node;
    }
}
