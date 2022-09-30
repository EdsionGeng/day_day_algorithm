package com.edison.algorithm.offer;

import java.util.*;

//最小K个数
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[0];
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);

        for (int num : arr) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if(num<queue.peek()){
                queue.poll();
                queue.offer(num);
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for (int num : queue) {
            res[idx++] = num;
        }
        return res;

    }

    public static void main(String[] args) {
        Offer40 offer40 = new Offer40();
        offer40.getLeastNumbers(new int[]{0,1,2,1},1);
    }
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int num : arr) {
            if (cnt < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
                continue;
            }
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if (entry.getKey() > num) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (entry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
        }
        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            while (freq-- > 0) {
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }
    public int[] getLeastNumbers4(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[0];
        return quickSearch(arr, 0, arr.length - 1, k - 1);

    }

    private int[] quickSearch(int[] nums, int low, int high, int k) {
        int j = partition(nums, low, high);
        if (j == k) return Arrays.copyOf(nums, j + 1);
        return j > k ? quickSearch(nums, low, j - 1, k) : quickSearch(nums, j + 1, high, k);
    }

    private int partition(int[] nums, int low, int high) {
        int v = nums[low];
        int i = low, j = high + 1;
        while (true) {
            while (++i <= high && nums[i] < v) ;
            while (--j >= low && nums[j] > v) ;
            if (i >= j) break;
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[low] = nums[j];
        nums[j] = v;
        return j;
    }
}
