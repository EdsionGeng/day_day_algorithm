package com.edison.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * 不同的二叉搜索树2
 *
 * @author gengyc
 * @create 2022-01-21 16:00
 */
public class LeetCode95 {
    //给定一个整数 n，生成所有由 1 … n 为节点所组成的二叉搜索树。
//
//示例:
//
//输入: 3
//输出:
//[
//[1,null,3,2],
//[3,2,null,1],
//[3,1,null,null,2],
//[2,1,3],
//[1,null,2,null,3]
//]
//解释:
//以上的输出对应以下 5 种不同结构的二叉搜索树：
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i < end; i++) {
            List<TreeNode> subLeftTree = generateTrees(start, i - 1);
            List<TreeNode> subRightTree = generateTrees(i + 1, end);
            for (TreeNode left : subLeftTree) {
                for (TreeNode right : subRightTree) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;
                    res.add(treeNode);
                }
            }
        }
        return res;

    }
}