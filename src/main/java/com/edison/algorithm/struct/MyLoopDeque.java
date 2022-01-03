package com.edison.algorithm.struct;

/**
 * 描述:
 * 双向队列
 *
 * @author gengyc
 * @create 2021-12-23 11:00
 */
public class MyLoopDeque {
    /**
     * MyCircularDeque(k)：构造函数,双端队列的大小为k。
     * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
     * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
     * deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
     * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
     * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
     * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
     * isEmpty()：检查双端队列是否为空。
     * isFull()：检查双端队列是否满了。
     */
    private int[] data;
    private int front;
    private int rear;
    private int maxSize;

    public MyLoopDeque(int k) {
        data = new int[k + 1];
        front = 0;
        rear = 0;
        maxSize = k + 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else {
            front = (front + maxSize - 1) % maxSize;
            data[front] = value;
        }
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else {
            data[rear] = value;
            rear = (rear + 1) % maxSize;
        }
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % maxSize;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear + maxSize - 1) % maxSize;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return data[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return data[(rear + maxSize - 1) % maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public static void main(String[] args) {
        MyLoopDeque myLoopDeque = new MyLoopDeque(5);
        myLoopDeque.insertFront(1);
        myLoopDeque.insertLast(5);
        myLoopDeque.insertFront(2);
        myLoopDeque.insertFront(3);
        myLoopDeque.insertFront(4);
        myLoopDeque.insertLast(6);
    }
}