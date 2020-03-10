package com.edison.algorithm.struct;

public class MinHeap {

    public static void main(String[] args) {
        int[] a = {45, 36, 18, 53, 72, 30, 48, 93, 15, 35};
        java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            minHeap.offer(a[i]);

        }

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()+" ");
        }
        System.out.println();

    }
}
