package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 反转链表
 *
 * @author gengyc
 * @create 2022-03-02 10:15
 */
public class LeetCode206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;//前指针节点
        ListNode cur = head;//当前指针节点
        while (cur != null) {
            ListNode nextTemp = cur.next;//临时节点，暂存当前结点下一节点，用于后移
            cur.next = prev;//将当前节点指向它前面的节点
            prev = cur;//前指针后移
            cur = nextTemp;//当前指针后移
        }
        return prev;
    }
}