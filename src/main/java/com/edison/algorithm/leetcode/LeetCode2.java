package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 两数相加 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author gengyongchang
 * @create 2019-12-21 14:53
 */
public class LeetCode2 {

    public static ListNode twoAdd(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        int more = 0;
        ListNode pre = dummy;
        while (node1 != null || node2 != null || more > 0) {
            int sum = (node1 == null ? 0 : node1.val) + (node2 == null ? 0 : node2.val) + more;
            more = sum / 10;
            sum %= 10;
            pre.next = new ListNode(sum);
            pre = pre.next;
            //pre = pre.next;
            //pre = listNode;
            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
        }
        return dummy.next;
    }
    public static ListNode add(ListNode l1,ListNode l2){
        ListNode resNode = new ListNode(-1);//链表头节点，输出的时候这个节点不要
        ListNode currNode = resNode; //当前使用的节点
        int carry = 0;//进位
        int l1Val;  //上数
        int l2Val;  //下数
        int temp;
        while (l1 != null || l2 != null || carry > 0) {
            l1Val = l1 == null ? 0 : l1.val;
            l2Val = l2 == null ? 0 : l2.val;
            temp = l1Val + l2Val + carry;  //上数 加 下数 加 进位
            carry = temp / 10;  //获得进位的数值?
            currNode.next = new ListNode(temp % 10);//把当前位的值写入链表
            currNode = currNode.next;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;//移位，但是我们知道这两个都没有下一位了
        }
        return resNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.setNext(node2);
        node2.setNext(node3);

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node4.setNext(node5);
        node5.setNext(node6);

        ListNode result = twoAdd(node1, node4);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    static class ListNode {
        private int val;
        private ListNode next;

        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}