package com.edison.algorithm.struct;

/**
 * @Description 有序链表
 * @Date 2020/3/5下午11:54
 * @Created by edsiongeng
 */
public class SortLink {
    private LinkNode first;

    public SortLink() {
        this.first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }


    public void insert(LinkNode node) {
        int key = node.getKey();
        LinkNode previous = null;
        LinkNode current = first;
        while (current != null && current.getKey() < key) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = node;
        } else {
            previous.next = node;
        }
        node.next = current;
    }

    public void delete(int key) {
        LinkNode previous = null;
        LinkNode current = first;
        if (isEmpty()) {
            System.out.println("Linked is empty!");
            return;
        }
        while (current != null && current.getKey() != key) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
    }

    public LinkNode find(int key) {
        LinkNode current = first;
        while (current != null && current.getKey() <= key) {
            if (current.getKey() == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayLink() {
        System.out.println("Link(First -> Last");
        LinkNode current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }

    class LinkNode {
        private int data;
        public LinkNode next;

        public LinkNode(int data) {
            this.data = data;
        }

        public int getKey() {
            return data;
        }

        public void displayLink() {
            System.out.println(data + " ");
        }
    }
}
