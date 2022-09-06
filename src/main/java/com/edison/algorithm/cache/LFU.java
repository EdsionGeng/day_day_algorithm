package com.edison.algorithm.cache;

import java.util.*;

/**
 * 最少访问次数淘汰
 */
public class LFU<K, V> {


    private TreeMap<Integer, List<Node<K, V>>> countMap = null;
    private HashMap<K, Node<K, V>> cache = null;
    private int size;

    public LFU(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid size!");
        }
        countMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        cache = new HashMap<>(size);
        this.size = size;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            int count = node.getCount();
            node.value = value;
            node.setCount(count + 1);
            rmCountNode(count, node);
            addCountNode(count + 1, node);
            return;
        }
        if (cache.size() == size) {
            Map.Entry<Integer, List<Node<K, V>>> entry = countMap.firstEntry();
            Node node = entry.getValue().get(0);
            rmCountNode(node.getCount(), node);
            cache.remove(node.getKey());
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        addCountNode(node.getCount(), node);
        return;
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        Node node = cache.get(key);
        rmCountNode(node.count, node);
        addCountNode(node.count + 1, node);
        node.setCount(node.getCount() + 1);
        return (V) node.getValue();
    }

    public void rmCountNode(int count, Node node) {
        List<Node<K, V>> list = countMap.get(count);
        if (list.size() == 1) {
            countMap.remove(count);
        } else {
            list.remove(node);
        }
    }

    public void addCountNode(int count, Node node) {
        List<Node<K, V>> list = countMap.get(count);
        if (list == null) {
            list = new ArrayList<>();
            countMap.put(count, list);
        }
        list.add(node);
    }

    class Node<K, V> {
        private K key;
        private V value;
        private int count;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, int count) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

    }
}
