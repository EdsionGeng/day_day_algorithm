package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 实现K个一组翻转链表
 *
 * @author gengyc
 * @create 2021-12-30 16:33
 */
public class LeetCode25 {
    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。
     * <p>
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 示例 :
     * <p>
     * 给定这个链表：1->2->3->4->5
     * <p>
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * <p>
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     * <p>
     * 说明 :
     * <p>
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     */
    static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int canProceed = 0, count = 0;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode check = head;
        while (canProceed < k && check != null) {
            check = check.next;
            canProceed++;
        }
        if (canProceed == k) {
            while (count < k && cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count++;
            }
            if (next != null) {
                head.next = reverseKGroup(next, k);
            }
            return prev;
        } else {
            return head;
        }
    }

    public ListNode reverseList2(ListNode head) {
        ListNode reverseHead = null;
        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            if (next == null) {
                reverseHead = node;
            }
            node.next = prev;
            prev = node;
            node = next;
        }
        //     next = cur.next;
        //                cur.next = prev;
        //                prev = cur;
        //                cur = next;
        return reverseHead;
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode reverseHead = reverseList3(next);
        next.next=head;
        return reverseHead;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            //   next = cur.next;
            //                cur.next = prev;
            //                prev = cur;
            //                cur = next;
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        reverse(node1);
        reverseKGroup(node1, 3);
    }
}