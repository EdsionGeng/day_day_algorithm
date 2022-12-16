package com.edison.algorithm.leetcode;


import java.util.PriorityQueue;

//数据流中第K大元素
public class LeetCode703 {

    class KthLargest {
        PriorityQueue<Integer> pq;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for (int i : nums) {
                add(i);
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
            return pq.peek();

        }

    }
}
