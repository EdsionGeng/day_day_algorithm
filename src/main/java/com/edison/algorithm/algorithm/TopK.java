package com.edison.algorithm.algorithm;

/**
 * 描述:
 * TopK算法
 *
 * @author gengyc
 * @create 2021-12-09 16:39
 */
public class TopK {
    class MinHeap {
        private int[] data;

        public MinHeap(int[] data) {
            this.data = data;
            buildHeap();
        }

        private void buildHeap() {
            for (int i = (data.length - 2) / 2; i >= 0; i--) {
                heapify(i);
            }
        }

        private void heapify(int len) {
            int parent = len;
            int child = parent * 2 + 1;
            while (child < data.length) {
                if (child + 1 < data.length && data[child] > data[child + 1]) {
                    child++;
                }
                if (data[parent] > data[child]) {
                    swap(data, parent, child);
                    parent = child;
                    child = parent * 2 + 1;
                } else {
                    break;
                }
            }
        }

        private int getHeapTop() {
            if (data.length == 0) {
                throw new UnsupportedOperationException("Heap is empty,cant get value!");
            }
            return this.data[0];
        }

        private void addHeap(int num) {
            this.data[0] = num;
            heapify(0);
        }


        private void swap(int[] data, int a, int b) {
            int temp = data[a];
            data[a] = data[b];
            data[b] = temp;
        }
    }

    public int[] topK(int[] data, int k) {
        int[] topK = new int[k];
        System.arraycopy(data, 0, topK, 0, k);
        MinHeap minHeap = new MinHeap(topK);
        for (int i = k; i < data.length; i++) {
            int root = minHeap.getHeapTop();
            if (data[i] > root) {
                minHeap.addHeap(data[i]);
            }
        }
        return topK;
    }

    public static void main(String[] args) {
        TopK top = new TopK();
        int[] data = {12, 10, 4, 7, 30, 9, 6, 20};
        //提取data中的三个最大元素
        int[] topK = top.topK(data, 3);
        //12 30 20
        //输出topK数组中的元素
        for (int i = 0; i < topK.length; i++) {
            System.out.print(topK[i] + " ");
        }
        System.out.println();

    }

}