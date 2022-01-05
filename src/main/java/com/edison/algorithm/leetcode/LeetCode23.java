package com.edison.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 描述:
 * 合并K个排序链表
 *
 * @author gengyc
 * @create 2021-12-30 15:29
 */
public class LeetCode23 {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] s) {
        if (s.length == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);

        ListNode cur = dummyHead;
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode list : s) {
            if (list != null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            ListNode nextNode = queue.poll();
            cur.next = nextNode;
            cur = cur.next;
            if (nextNode.next != null) {
                queue.add(nextNode.next);
            }
        }
        return dummyHead.next;
    }
}