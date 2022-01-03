package com.edison.algorithm.struct;

/**
 * 描述:
 * 二叉堆实现
 *
 * @author gengyongchang
 * @create 2019-12-15 16:48
 */
public class MaxHeap2 {

    protected Integer[] data;
    protected int count;
    protected int capacity;

    public MaxHeap2(int capacity) {
        data = new Integer[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Integer item) {
        if ((count + 1) > capacity) {
            System.out.println("already full for array");
        }
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    private void shiftUp(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void swap(int i, int j) {
        Integer temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public Integer extractMax() {
        if (count <= 0) {
            System.out.println("heap is empty");
            return null;
        }
        Integer ret = data[1];
        swap(1, count);
        count--;
        shiftDown(1);
        return ret;
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
                j++;
            }
            if (data[k].compareTo(data[j]) >= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }

    }

    public static void main(String[] args) {
//        MaxHeap2 maxHeap = new MaxHeap2(100);
//
//        int N = 5; // 堆中元素个数
//        int M = 100; // 堆中元素取值范围[0, M)
//
//        for (int i = 0; i < N; i++) {
//            maxHeap.insert(new Integer((int) (Math.random() * M)));
//        }
//        System.out.println(maxHeap.size());
//
//
//        while (maxHeap.count != 0) {
//            System.out.print(maxHeap.extractMax() + " ");
//        }
        int[] arr = {1, 3, 0, 4, 0, 0};
        int count = 0, n = arr.length;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i];
            }
        }
        for (int i = count; i < n; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }


}