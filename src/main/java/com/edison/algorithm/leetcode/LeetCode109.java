package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 有序链表转换二叉搜索树
 *
 * @author gengyc
 * @create 2022-01-25 11:26
 */
public class LeetCode109 {
    //给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
//本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
//示例:
//
//给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return new TreeNode(head.val);

        ListNode pre = head;
        ListNode p = pre.next;
        ListNode q = p.next;
        //找到链表中的p
        while (q != null && q.next != null) {
            pre = pre.next;
            //p走一倍速度 q走两倍速度
            p = pre.next;
            q = q.next.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        LeetCode109 le = new LeetCode109();
        le.sortedListToBST(node1);
    }

}