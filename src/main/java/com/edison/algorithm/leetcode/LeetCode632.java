package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//最小区间
public class LeetCode632 {


    public int[] smallestRange(List<List<Integer>> nums) {
        int rangeLeft = 0, rangeRight = Integer.MAX_VALUE;
        int minRange = rangeRight - rangeLeft;
        int max = Integer.MIN_VALUE;
        int size = nums.size();
        int[] next = new int[size];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer index1, Integer index2) {
                return nums.get(index1).get(next[index1]) - nums.get(index2).get(next[index2]);
            }
        });
        for (int i = 0; i < size; i++) {
            priorityQueue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        while (true) {
            int minIndex = priorityQueue.poll();
            int curRange = max - nums.get(minIndex).get(next[minIndex]);
            if (curRange < minRange) {
                minRange = curRange;
                rangeLeft = nums.get(minIndex).get(next[minIndex]);
                rangeRight = max;
            }
            next[minIndex]++;
            if (next[minIndex] == nums.get(minIndex).size()) {
                break;
            }
            priorityQueue.offer(minIndex);
            max = Math.max(max, nums.get(minIndex).get(next[minIndex]));
        }

        return new int[]{rangeLeft, rangeRight};
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(10);
        list1.add(15);
        list1.add(24);
        list1.add(26);
        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(9);
        list2.add(12);
        list2.add(20);
        List<Integer> list3 = new ArrayList<>();
        list3.add(5);
        list3.add(18);
        list3.add(22);
        list3.add(30);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);

        LeetCode632 le = new LeetCode632();
        le.smallestRange(list);
    }
}
