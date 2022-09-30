package com.edison.algorithm.offer;


import java.util.ArrayDeque;
import java.util.Deque;

//从尾到头打印链表
public class Offer06 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();

        while (head != null) {
            stack.push(head.val);
            head = head.next;

        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        Offer06 offer = new Offer06();
        offer.reversePrint(node);

    }
}
