package com.edison.algorithm.leetcode;

/**
 * 描述:
 *
 * @author gengyc
 * @create 2022-01-15 9:43
 */
public class LeetCode61 {
    //给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
//示例 1:
//
//输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
//示例 2:
//
//输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL
    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head.next == null || k == 0) {
            return head;
        }
        ListNode cur = head;
        ListNode tail = null;
        int length = 0;
        while (cur.next != null) {
            cur = cur.next;
            length++;
        }
        tail = cur;
        cur.next = head;
        cur = head;
        int loop = length - k % length;
        for (int i = 0; i < loop; i++) {
            cur = cur.next;
            tail = tail.next;
        }
        tail.next=null;
        return cur;
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

//        ListNode cur = new ListNode(9);
//        cur.next = node1;
//        cur = node1;
        LeetCode61 leetCode61 = new LeetCode61();
        leetCode61.rotateRight(node1, 2);
        //  System.out.println(removeNode2(node1, 3).val);
    }
}