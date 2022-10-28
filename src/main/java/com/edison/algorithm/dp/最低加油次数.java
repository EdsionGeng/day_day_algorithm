package com.edison.algorithm.dp;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 最低加油次数 {

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int count = 0, n = stations.length, index = 0;
        while (true) {
            if (startFuel >= target) break;
            while (index < n && startFuel >= stations[index][0]) {
                queue.offer(stations[index][1]);
                index++;
            }
            if (queue.isEmpty()) {
                return -1;
            } else {
                startFuel += queue.poll();
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));
    }
}
