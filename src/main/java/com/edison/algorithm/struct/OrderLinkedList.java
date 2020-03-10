package com.edison.algorithm.struct;

/**
 * @Description 有序链表
 * @Date 2020/3/1下午10:52
 * @Created by edsiongeng
 */
public class OrderLinkedList {

    private Node head;

    public OrderLinkedList() {
        head = null;
    }

    //从小到大顺序排列
    public void insert(int value) {
        Node node = new Node(value);

        Node pre = null;

        Node current = head;

        while (current != null && value > current.data) {
            pre = current;
            current = current.next;
        }
        if (pre == null) {
            head = node;
            head.next = current;
        } else {
            pre.next = node;

            node.next = current;
        }


    }

    public void deleteHead() {
        head = head.next;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        OrderLinkedList orderLinkedList = new OrderLinkedList();
        orderLinkedList.insert(2);
        orderLinkedList.insert(3);
        orderLinkedList.insert(1);

    }


    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
