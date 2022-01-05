package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 两两交换链表节点
 *
 * @author gengyc
 * @create 2021-12-30 16:18
 */
public class LeetCode24 {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     * 示例:
     * <p>
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode pNode = head;
        while (pNode != null && pNode.next != null) {
            int temp = pNode.val;
            pNode.val = pNode.next.val;
            pNode.next.val = temp;
            pNode = pNode.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node1.next.next = node3;
        node1.next.next.next = node4;
        swapPairs(node1);

    }

}