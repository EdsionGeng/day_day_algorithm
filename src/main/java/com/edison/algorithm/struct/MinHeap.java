package com.edison.algorithm.struct;

public class MinHeap {
    private Integer[] data;
    private int count;
    private int capacity;


    public MinHeap(int capacity) {
        this.data = new Integer[capacity + 1];
        this.count = 0;
        this.capacity = capacity;

    }

    public Integer pop() {
        if (count == 0) {
            throw new RuntimeException("data is empty!");
        }
        int result = this.data[0];
        count -= 1;
        this.data[0] = this.data[this.count - 1];
        this.shiftDown(0);
        return result;
    }

    public void add(int x) {
        if (this.count > capacity) {
            throw new RuntimeException("data is full!");
        }
        this.data[count] = x;
        shiftUp(count);
        this.count++;
    }

    public void shiftUp(int index) {
        int parent = (index - 1) >> 1;
        while (index < this.count) {
            if (this.data[parent] > this.data[index]) {
                int temp = this.data[index];
                this.data[index] = this.data[parent];
                this.data[parent] = temp;
                index = parent;
                parent = (index - 1) >> 1;
            }
        }

    }

    public void shiftDown(int index) {
        int min_child = (index << 1) + 1;
        while (min_child < count) {
            if (min_child + 1 < count && data[min_child + 1] < data[min_child]) {
                min_child = min_child + 1;
            }
            if (data[index] < data[min_child]) {
                break;
            }
            int temp = data[min_child];
            data[index] = data[min_child];
            data[min_child] = temp;
            index = min_child;
            min_child = (index << 1) + 1;
        }
    }

    public static void main(String[] args) {



    }
}
