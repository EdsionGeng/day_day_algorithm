package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 相交链表
 *
 * @author gengyc
 * @create 2022-02-23 13:32
 */
public class LeetCode160 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode last = headB;
        while (last.next != null) {
            last = last.next;
        }
        last.next = headB;

        ListNode fast = headA;
        ListNode slow = headA;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = headA;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                last.next = null;
                return fast;
            }
        }
        last.next = null;
        return null;
    }

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(4);
        ListNode nodeA_2 = new ListNode(1);

        ListNode nodeB = new ListNode(5);
        ListNode nodeB_2 = new ListNode(0);
        ListNode nodeB_3 = new ListNode(1);

//        ListNode node1 = new ListNode(8);
//        ListNode node2 = new ListNode(4);
//        ListNode node3 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;

        nodeA.next = nodeA_2;
//        nodeA.next.next = node1;

        nodeB.next = nodeB_2;
        nodeB.next.next = nodeB_3;
//        nodeB_3.next = node1;

        LeetCode160 le = new LeetCode160();
        ListNode result = le.getIntersectionNode(nodeA, nodeB);
        System.out.println(result);

    }

}