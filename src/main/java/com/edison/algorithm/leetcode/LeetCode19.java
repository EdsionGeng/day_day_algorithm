package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 删除链表倒数N个节点
 *
 * @author gengyc
 * @create 2021-12-29 17:34
 */
public class LeetCode19 {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        return removeNode(head, n) == n ? head.next : head;
    }

    public static int removeNode(ListNode node, int n) {
        if (node.next == null) return 1;
        int m = removeNode(node.next, n);
        if (m == n) {
            if (m == 1) {
                node.next = null;
            } else {
                node.next = node.next.next;
            }
        }
        return m + 1;

    }

    public static ListNode removeNode2(ListNode node, int n) {
        ListNode p = new ListNode(5);
        ListNode q = new ListNode(5);
        p.next = node;
        q.next = node;
        int i = 0;
        while (i < n) {
            q = q.next;
            i++;
        }
        while (q.next != null) {
            q = q.next;
            p = p.next;
        }
        if (p.next == node) {
            return node;
        } else {
            p.next = p.next.next;
        }
        return node;
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
        System.out.println(removeNode2(node1, 3).val);

    }

}