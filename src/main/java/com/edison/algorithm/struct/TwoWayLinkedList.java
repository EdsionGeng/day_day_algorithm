package com.edison.algorithm.struct;

/**
 * @Description 双向链表
 * @Date 2020/3/2下午2:08
 * @Created by edsiongeng
 */
public class TwoWayLinkedList {

    private Node head;//链表头

    private Node tail;//链表尾

    private int size;//链表节点个数


    public TwoWayLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }


    //在链表头增加节点
    public void addHead(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            size++;
        }
    }


    public void addTail(Object value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public Node deleteHead() {
        Node temp = head;
        if (size != 0) {
            head = head.next;
            head.prev = null;
            size--;
        }
        return temp;
    }

    public Node deleteTail() {
        Node temp = tail;
        if (size != 0) {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
        return temp;
    }

    public int getSize() {
        return size;

    }

    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 反转链表
     *
     * @param node
     * @return
     */
    public static Node reverse(Node node) {
        if (node.next == null) {
            return node;
        }
        Node last = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }


    /**
     * 反转链表前N个节点
     *
     * @param args
     */


    Node successor = null;

    /**
     * 1、base case 变为 n == 1，反转一个元素，就是它本身，同时要记录后驱节点。
     * <p>
     * 2、刚才我们直接把 head.next 设置为 null，因为整个链表反转后原来的 head 变成了整个链表的最后一个节点。但现在 head 节点在递归反转之后不一定是最后一个节点了，所以要记录后驱 successor（第 n + 1 个节点），反转之后将 head 连接上。
     *
     * @param head
     * @param n
     * @return
     */
    public Node reverseN(Node head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        //以head.next为起点，需要反转前n-1个节点
        Node last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * 给一个索引区间 [m,n]（索引从 1 开始），仅仅反转区间中的链表元素
     * @param head
     * @param m
     * @param n
     * @return
     */
    Node reverseBetween(Node head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        Node result = reverse(node);

        while (result != null) {
            System.out.println(result.data);
            result = result.next;

        }

    }

    private static class Node {

        private Object data;

        private Node next;

        private Node prev;

        public Node(Object data) {
            this.data = data;
        }
    }
}
