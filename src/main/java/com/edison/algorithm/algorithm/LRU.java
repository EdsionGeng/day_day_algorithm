package com.edison.algorithm.algorithm;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @Description 最近未久使用淘汰策略
 * 基于双向链表+哈希表组成，其中双向链表由哈希链表节点构成
 * 封装为LRU（K,V）
 * 对外提供get,put,iterator遍历数据
 * @Date 2020/8/17下午10:15
 * @Created by edsiongeng
 */
public class LRU<K, V> implements Iterable<K> {
    private Node head;
    private Node tail;
    private HashMap<K, Node> map;
    private int maxSize;


    public LRU(int maxSize) {
        this.maxSize = maxSize;
        this.map = new HashMap<>(maxSize * 4 / 3);
        head.next = tail;
        tail.pre = head;
    }


    private V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        //最新访问数据移动到链表头
        Node node = map.get(key);
        remove(node);
        addFirst(node);
        return node.v;

    }

    private void put(K key, V value) {
        //若存在，旧数据删除
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
        }

        //新数据对应节点插入链表头
        Node node = new Node(key, value);
        map.put(key, node);
        addFirst(node);
        //判断是否需要淘汰数据
        if (map.size() > maxSize) {
            removeLast();
            //　数据节点淘汰后，同时删除map中的映射
            map.remove(node.k);
        }
    }

    //将指定节点加入链表头

    private void addFirst(Node node) {
        Node next = head.next;

        head.next = node;
        node.pre = head;

        node.next = next;
        next.pre = node;
    }

    //从链表中删除节点
    private void remove(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;

        node.next = null;
        node.pre = null;
    }

    private Node removeLast() {
        Node node = tail.pre;
        remove(node);
        return node;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {

            private Node cur = head.next;

            @Override
            public boolean hasNext() {
                return cur != tail;
            }

            @Override
            public K next() {
                Node node = cur;
                cur = cur.next;
                return node.k;
            }
        };
    }

    private class Node {
        Node pre;
        Node next;
        K k;
        V v;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }
}
