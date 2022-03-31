package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 描述:
 * 二叉树搜索迭代器
 *
 * @author gengyc
 * @create 2022-02-28 19:31
 */
public class LeetCode173 {
    //实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
//
//调用 next() 将返回二叉搜索树中的下一个最小的数。
//BSTIterator iterator = new BSTIterator(root);
//iterator.next(); // 返回 3
//iterator.next(); // 返回 7
//iterator.hasNext(); // 返回 true
//iterator.next(); // 返回 9
//iterator.hasNext(); // 返回 true
//iterator.next(); // 返回 15
//iterator.hasNext(); // 返回 true
//iterator.next(); // 返回 20
//iterator.hasNext(); // 返回 false
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public class BstIterator {
        private TreeNode root;
        private List<Integer> result;
        private Iterator it;

        public void inorder(TreeNode root) {
            if (root != null) {
                inorder(root.left);
                result.add(root.val);
                inorder((root.right));
            }
        }

        public BstIterator(TreeNode root) {
            this.root = root;
            this.result = new ArrayList<>();
            inorder(this.root);
            this.it = result.iterator();
        }

        public int next() {
            return (int) this.it.next();
        }

        public boolean hasNext() {
            return (boolean) this.it.hasNext();
        }
    }

}