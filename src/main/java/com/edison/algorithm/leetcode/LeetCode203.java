package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 移除链表元素
 *
 * @author gengyc
 * @create 2022-03-01 17:14
 */
public class LeetCode203 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElement(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        head.next = head;
        ListNode cur = header;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return header.next;
    }
}