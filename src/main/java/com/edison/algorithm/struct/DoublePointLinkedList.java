package com.edison.algorithm.struct;

/**
 * @Description 双端链表
 * @Date 2020/3/1下午10:23
 * @Created by edsiongeng
 */
public class DoublePointLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublePointLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public void addHead(Object data) {
        Node node = new Node(data);
        if (size == 0) {
            head = node;
            tail = node;
            size++;
        } else {
            node.next = head;
            head = node;
            size++;
        }
    }

    public void addTail(Object data) {
        Node node = new Node(data);

        if (size == 0) {
            head = node;
            tail = node;
            size++;
        } else {
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean deleteHead() {
        if (size == 0) {
            return false;
        }
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return true;
    }

    public boolean deleteTail() {
        if (size == 0) {
            return false;
        }
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return true;
    }


    public void display() {
        if (size > 0) {
            Node node = head;
            int tempSize = size;
            if (tempSize == 1) {
                System.out.println("[" + node.data + "]");
                return;
            }
            while (tempSize > 0) {
                if (node.equals(head)) {
                    System.out.print("[" + node.data + "->");
                } else if (node.next == null) {
                    System.out.print(node.data + "]");
                } else {
                    System.out.print(node.data + "->");
                }
                node = node.next;
                tempSize--;
            }
        } else {
            System.out.println("[]");
        }
    }


    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }
}
