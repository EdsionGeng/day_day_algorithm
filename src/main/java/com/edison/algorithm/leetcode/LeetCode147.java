package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 链表插入排序
 *
 * @author gengyc
 * @create 2022-02-15 16:05
 */
public class LeetCode147 {
    //示例 1：
//
//输入: 4->2->1->3
//输出: 1->2->3->4
//示例 2：
//
//输入: -1->5->3->4->0
//输出: -1->0->3->4->5
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertSortList(ListNode head) {
        ListNode dummy = new ListNode(0), pre;
        dummy.next = head;

        while (head != null && head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            pre = dummy;
            while (pre.next.val < head.next.val) pre = pre.next;
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return dummy.next;
    }
}