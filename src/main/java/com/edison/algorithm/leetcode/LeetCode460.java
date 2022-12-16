package com.edison.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

//LFU缓存
public class LeetCode460 {

    class LFUCache {

        //缓存容量，时间戳
        int capacity, time;
        Map<Integer, Node> keyTable;
        TreeSet<Node> s;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.time = 0;
            keyTable = new HashMap<>();
            s = new TreeSet<>();


        }

        public int get(int key) {
            if (capacity == 0) return -1;
            if (!keyTable.containsKey(key)) return -1;
            Node cache = keyTable.get(key);
            s.remove(cache);
            cache.cnt += 1;
            cache.time = ++time;
            s.add(cache);
            keyTable.put(key, cache);
            return cache.value;

        }

        public void put(int key, int value) {
            if (capacity == 0) return;
            if (!keyTable.containsKey(key)) {
                if (keyTable.size() == capacity) {
                    keyTable.remove(s.first().key);
                    s.remove(s.first());
                }
                Node cache = new Node(1, ++time, key, value);
                keyTable.put(key, cache);
                s.add(cache);
            } else {
                Node cache = keyTable.get(key);
                s.remove(cache);
                cache.cnt += 1;
                cache.time = ++time;
                cache.value = value;
                s.add(cache);
                keyTable.put(key, cache);
            }

        }
    }

    class Node implements Comparable<Node> {
        int cnt, time, key, value;

        Node(int cnt, int time, int key, int value) {
            this.cnt = cnt;
            this.time = time;
            this.key = key;
            this.value = value;
        }

        public boolean equals(Object anObject) {
            if (this == anObject) {
                return true;
            }
            if (anObject instanceof Node) {
                Node rhs = (Node) anObject;
                return this.cnt == rhs.cnt && this.time == rhs.time;
            }
            return false;
        }

        @Override
        public int compareTo(Node rhs) {
            return cnt == rhs.cnt ? time - rhs.time : cnt - rhs.cnt;
        }

        public int hashCode() {
            return cnt * 1000000007 + time;
        }
    }
}
