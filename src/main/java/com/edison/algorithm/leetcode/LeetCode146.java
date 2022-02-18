package com.edison.algorithm.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 描述:
 * LRU缓存机制
 *
 * @author gengyc
 * @create 2022-02-15 15:57
 */
public class LeetCode146 {
    class LRUCache {
        int capacity;
        LinkedHashMap<Integer, Integer> cache;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return cache.size() > capacity;
                }
            };
        }

        public int get(int key) {
            return cache.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            cache.put(key, value);
        }
    }
}