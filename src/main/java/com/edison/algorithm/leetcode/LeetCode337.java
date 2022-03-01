package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 打家劫舍3
 *
 * @author gengyc
 * @create 2022-03-01 11:26
 */
public class LeetCode337 {
//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
// 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
// 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
//————————————————
//版权声明：本文为CSDN博主「南     墙」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/a1439775520/article/details/104487592
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    public int[] helper(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1] + Math.max(right[0], right[1]));
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}