package com.edison.algorithm.leetcode;

//链表的中间节点
public class LeetCode876 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        if (head.next.next == null) return head.next;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode detectCycle(ListNode head) {
        if (head.next == null) return head;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }
}
