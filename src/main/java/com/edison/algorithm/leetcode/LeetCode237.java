package com.edison.algorithm.leetcode;

/**
 * @Description 删除节点
 * @Date 2022/4/1下午11:45
 * @Created by edsiongeng
 */
public class LeetCode237 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        root.next = new ListNode(5);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(9);
        LeetCode237 le = new LeetCode237();
        le.deleteNode(root.next);
    }
}
