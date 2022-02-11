package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 复制带随机指针的链表
 *
 * @author gengyc
 * @create 2022-02-09 15:33
 */
public class LeetCode138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node node = head;
        while (node != null) {
            Node clone = new Node(node.val, node.next, null);
            Node temp = node.next;
            node.next = clone;
            node = temp;
        }
        node = head;
        while (node != null) {
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        node = head;
        Node cloneHead = head.next;
        while (node.next != null) {
            Node temp = node.next;
            node.next = node.next.next;
            node = temp;
        }
        return cloneHead;

    }
}