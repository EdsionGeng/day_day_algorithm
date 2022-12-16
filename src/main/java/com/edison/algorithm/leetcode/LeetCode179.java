package com.edison.algorithm.leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode179 {

    public String largestNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        for (int i = 0; i < nums.length; i++) {
            queue.offer(String.valueOf(nums[i]));
        }
        StringBuffer sb = new StringBuffer();
        while (queue.size() != 0) {
            sb.append(queue.poll());
        }
        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode179 le = new LeetCode179();
        System.out.println(le.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
