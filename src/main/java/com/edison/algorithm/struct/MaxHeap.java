package com.edison.algorithm.struct;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxHeap {
    public static void main(String[] args) {

        int[] a = {45, 36, 18, 53, 72, 30, 48, 93, 15, 35};
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i <a.length ; i++) {
            maxHeap.offer(a[i]);
        }
        for (int i = 0; i < a.length; i++) {

            System.out.println(maxHeap.poll());
        }

    }
}
