package com.edison.algorithm.struct;

/**
 * @Description 堆
 * @Date 2020/3/8下午11:50
 * @Created by edsiongeng
 */
public class Heap {

    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int mx) {
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public boolean insert(int key) {
        if (isFull()) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];
        while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    //向下调整
    public void trickleDown(int index) {
        Node top = heapArray[index];
        int largeChildIndex;
        while (index < currentSize) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = leftChildIndex + 1;
            //find large child
            if (rightChildIndex < currentSize && heapArray[leftChildIndex].getKey() < heapArray[rightChildIndex].getKey()) {
                largeChildIndex = rightChildIndex;
            } else {
                largeChildIndex = leftChildIndex;
            }
            if (top.getKey() >= heapArray[largeChildIndex].getKey()) {
                break;
            }
            heapArray[index] = heapArray[largeChildIndex];
            index = largeChildIndex;

        }
        heapArray[index] = top;

    }

    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);
        if (oldValue < newValue) {
            trickleUp(index);
        } else {
            trickleDown(index);

        }
        return true;

    }

    private class Node {
        private int iData;

        public Node(int key) {
            iData = key;
        }

        public int getKey() {
            return iData;
        }

        public void setKey(int key) {
            iData = key;
        }
    }
}
