package com.edison.algorithm.offer;

import com.edison.algorithm.leetcode.LeetCode295;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

//数据流中的中位数
public class Offer41 {
    //    PriorityQueue<Integer> min;
//    PriorityQueue<Integer> max;
//
//    public Offer41() {
//        min = new PriorityQueue<>();
//        max = new PriorityQueue<>((a, b) -> b - a);
//
//    }
//
//    public void addNum(int num) {
//        min.add(num);
//        if (min.size() > max.size()) {
//            max.add(min.remove());
//        }
//    }
//
//    public double findMedian() {
//        if (min.size() == max.size()) {
//            return (max.peek() + min.peek()) / 2.0;
//        }
//        return max.peek();
//    }
//
//    public static void main(String[] args) {
//        Offer41 le = new Offer41();
//        le.addNum(2);
//        le.addNum(3);
//        System.out.println(le.findMedian());
//        le.addNum(4);
//        System.out.println(le.findMedian());
//        le.addNum(5);
//        System.out.println(le.findMedian());
//    }
    TreeMap<Integer, Integer> nums;
    int n;
    int[] left;
    int[] right;

    public Offer41() {
        nums = new TreeMap<Integer, Integer>();
        n = 0;
        left = new int[2];
        right = new int[2];
    }

    public void addNum(int num) {
        nums.put(num, nums.getOrDefault(num, 0) + 1);
        if (n == 0) {
            left[0] = right[0] = num;
            left[1] = right[1] = 1;
        } else if ((n & 1) != 0) {
            if (num < left[0]) {
                decrease(left);
            } else {
                increase(right);
            }
        } else {
            if (num > left[0] && num < right[0]) {
                increase(left);
                decrease(right);
            } else if (num >= right[0]) {
                increase(left);
            } else {
                decrease(right);
                System.arraycopy(right, 0, left, 0, 2);
            }
        }
        n++;
    }

    public double findMedian() {
        return (left[0] + right[0]) / 2.0;
    }

    private void increase(int[] iterator) {
        iterator[1]++;
        if (iterator[1] > nums.get(iterator[0])) {
            iterator[0] = nums.ceilingKey(iterator[0] + 1);
            iterator[1] = 1;
        }
    }

    public void decrease(int[] iterator) {
        iterator[1]--;
        if (iterator[1] == 0) {
            iterator[0] = nums.floorKey(iterator[0] - 1);
            iterator[1] = nums.get(iterator[0]);
        }
    }

}
