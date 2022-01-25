package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 反转链表2
 *
 * @author gengyc
 * @create 2022-01-21 11:24
 */
public class LeetCode92 {
    //反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
//说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
//示例:
//
//输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
//通过次数33,953提交次数69,208
//
//PS：
//
//实现思路 ：以1->2->3->4->5, m = 2, n=4 为例:
//
//定位到要反转部分的头节点 2，head = 2；前驱结点 1，pre = 1；
//当前节点的下一个节点3调整为前驱节点的下一个节点 1->3->2->4->5,
//当前结点仍为2， 前驱结点依然是1，重复上一步操作。。。
//1->4->3->2->5.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        head = pre.next;
        for (int i = m; i < n; i++) {
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        LeetCode92 le = new LeetCode92();
        le.reverseBetween(listNode, 2, 4);

    }
}