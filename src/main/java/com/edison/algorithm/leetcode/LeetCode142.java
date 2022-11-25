package com.edison.algorithm.leetcode;

import com.edison.algorithm.struct.ListNode;

//找出链表的环
public class LeetCode142 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        do {
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;

        } while (fast != slow);

        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
