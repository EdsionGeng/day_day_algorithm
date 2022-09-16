package com.edison.algorithm.leetcode;

import java.util.*;

//前K个高频单词
public class LeetCode692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String str : words) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> {
            if (countMap.get(s1).equals(countMap.get(s2))) {
                return s2.compareTo(s1);
            } else {
                return countMap.get(s1) - countMap.get(s2);
            }
        });
        for (String s : countMap.keySet()) {
            minHeap.offer(s);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (minHeap.size() > 0) {
            res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        LeetCode692 le = new LeetCode692();
        List<String> res = le.topKFrequent(new String[]{"day", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"
        }, 4);
        for (String str : res) {
            System.out.println(str);
        }
    }
}
