package com.edison.algorithm.leetcode;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//会议室
public class LeetCode253 {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        allocator.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }


    public static void main(String[] args) {
        LeetCode253 le = new LeetCode253();
        le.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}});
    }
}
