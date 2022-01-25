package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 删除排序链表中的重复元素
 *
 * @author gengyc
 * @create 2022-01-19 13:55
 */
public class LeetCode83 {
    //给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
    //
    //示例 1:
    //
    //输入: 1->1->2
    //输出: 1->2
    //示例 2:
    //
    //输入: 1->1->2->3->3
    //输出: 1->2->3
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }
}