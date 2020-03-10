package com.edison.algorithm.struct;

/**
 * @Description 单向链表
 * @Date 2020/3/1下午5:31
 * @Created by edsiongeng
 */
public class SingleLinkedList {

    private int size;//链表节点个数
    private Node head;//头节点

    public SingleLinkedList() {
        size = 0;
        head = null;
    }
    //在链表头添加元素

    public Object addHead(Object obj) {
        Node newHead = new Node(obj);
        if (size == 0) {
            head = newHead;
        } else {
            newHead.next = head;
            head = newHead;
        }
        size++;
        return obj;
    }

    //在链表头删除元素
    public Object deleteHead() {
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }
//查找指定元素，找到则返回节点，找不到返回null

    public Node find(Object obj) {
        Node current = head;
        int tempSize = size;

        while (tempSize > 0) {
            if (obj.equals(current.data)) {
                return current;
            } else {
                current = current.next;
            }
            tempSize--;
        }
        return null;
    }

    public boolean delete(Object value) {
        if (size == 0) {
            return false;
        }
        Node current = head;
        Node previous = head;

        while (current.data!=(value)) {
            if (current.next == null) {
                return false;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = current.next;
            size--;
        } else {
            previous.next = current.next;
            size--;
        }
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
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
            System.out.println();
        } else {
            System.out.println("[]");
        }
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addHead("A");
        singleLinkedList.addHead("B");
        singleLinkedList.addHead("C");
        singleLinkedList.addHead("D");

        singleLinkedList.display();
        singleLinkedList.delete("C");
        singleLinkedList.display();

        System.out.println(singleLinkedList.find("B"));
    }

    private class Node {
        private Object data;//每个节点数据
        private Node next;//每个节点指向下一个节点链接

        public Node(Object data) {
            this.data = data;
        }
    }
}
