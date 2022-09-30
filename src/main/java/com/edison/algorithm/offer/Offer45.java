package com.edison.algorithm.offer;


import java.util.PriorityQueue;
import java.util.Queue;

//把数组排成最小的数
//[10,2] ->102
public class Offer45 {

    public String minNumber(int[] nums) {
        Queue<String> heap = new PriorityQueue<>((x, y) -> (x + y).compareTo(y + x));
        for (int num : nums) {
            heap.offer(String.valueOf(num));
        }
        String res = "";
        while (!heap.isEmpty()) {
            res += heap.poll();
        }
        if (res.charAt(0) == '0') return "0";
        return res;
    }

    public static void main(String[] args) {
        Offer45 offer45 = new Offer45();
        System.out.println(offer45.minNumber(new int[]{10,2}));
    }
}
