package com.edison.algorithm.struct;

public class PriorityQueue {
    private int maxSize;
    private int[] priQueArray;
    private int nItems;

    public PriorityQueue(int s) {
        maxSize = s;
        priQueArray = new int[maxSize];
        nItems = 0;
    }

    public void insert(int value) {
        int j;
        if (isEmpty()) {
            priQueArray[nItems++] = value;
        } else {
            j = nItems - 1;
            while (j >= 0 && value > priQueArray[j]) {
                priQueArray[j + 1] = priQueArray[j];
                j--;
            }
            priQueArray[j + 1] = value;
            nItems++;
        }
    }

    public int peekMin() {
        return priQueArray[nItems - 1];
    }


    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(3);
        priorityQueue.insert(4);
        priorityQueue.insert(2);
        priorityQueue.insert(8);

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.peekMin());
        }
    }
}
