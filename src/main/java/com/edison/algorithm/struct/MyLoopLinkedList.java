package com.edison.algorithm.struct;

import lombok.Data;

/**
 * 描述:
 * 链表循环队列
 *
 * @author gengyc
 * @create 2021-12-23 10:33
 */
public class MyLoopLinkedList {
    Node front;
    Node rear;
    int maxSize;
    int len = 0;

    public MyLoopLinkedList(int k) {
        front = new Node(0);
        rear = front;
        maxSize = k;
        len = 0;
    }

    public boolean enqueue(int value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node(value);
        rear.next = node;
        rear = node;
        len++;
        return true;
    }

    public boolean dequeue() {
        if (isEmpty()) {
            return false;
        } else {
            front.next = front.next.next;
            len--;
            if (len == 0) {
                rear = front;
            }
        }
        return true;
    }


    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == maxSize;
    }

    @Data
    class Node {
        int data;
        Node next;

        public Node() {

        }

        public Node(int data) {
            this.data = data;
        }
    }
}