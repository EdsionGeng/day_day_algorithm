package com.edison.algorithm.struct;

/**
 * @Description 队列
 * @Date 2020/2/29下午11:50
 * @Created by edsiongeng
 */
public class MyQueue {

    private Object[] queArray;
    private int maxSize;
    private int front;
    private int rear;
    private int nItems;

    public MyQueue(int size) {
        maxSize = size;
        queArray = new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(int value) {
        if (isFull()) {

        } else {
            if (rear == maxSize - 1) {
                rear = -1;
            }
            queArray[++rear] = value;
            nItems++;
        }

    }

    public Object remove() {

        Object removeValue = null;
        if (!isEmpty()) {
            removeValue = queArray[front];
            queArray[front] = null;
            front++;
            if (front == maxSize) {
                front = 0;
            }
            nItems--;
            return removeValue;

        }
        return removeValue;

    }


    public Object peekFront() {
        return queArray[front];
    }


    public int getSize() {
        return nItems;
    }


    public boolean isEmpty() {
        return nItems == 0;
    }


    public boolean isFull() {
        return nItems == maxSize;
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(3);
        myQueue.insert(1);
        myQueue.insert(2);
        myQueue.insert(3);


        System.out.println(myQueue.peekFront()); //1
        myQueue.remove();//queArray数组数据为[null,2,3]
        System.out.println(myQueue.peekFront()); //2

        myQueue.insert(4);//queArray数组数据为[4,2,3]
        myQueue.insert(5);//队列已满,queArray数组数据为[4,2,3]
    }
}
