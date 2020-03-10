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

    public boolean isEmpty(){
        return size==0;
    }

    private class Node {

        private Object data;

        private Node next;

        private Node prev;

        public Node(Object data) {
            this.data = data;
        }
    }
}
