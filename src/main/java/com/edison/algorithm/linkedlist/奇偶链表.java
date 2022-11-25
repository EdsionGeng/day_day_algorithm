package com.edison.algorithm.linkedlist;

import com.edison.algorithm.struct.ListNode;

public class 奇偶链表 {


    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, firstEven = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = firstEven;
        return head;
    }
}
