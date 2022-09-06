package com.edison.algorithm.cache.consistent_hash;

import java.util.*;

public class TestHashCircle {
    // 机器节点IP前缀
    private static final String IP_PREFIX = "192.168.0.";

    public static void main(String[] args) {
        // 每台真实机器节点上保存的记录条数
        Map<String, Integer> map = new HashMap<String, Integer>();

        // 真实机器节点, 模拟10台
        List<Node<String>> nodes = new ArrayList<Node<String>>();
        for (int i = 1; i <= 10; i++) {
            map.put(IP_PREFIX + i, 0); // 初始化记录
            Node<String> node = new Node<String>(IP_PREFIX + i, "node" + i);
            nodes.add(node);
        }

        IHashService iHashService = new HashService();
        ConsistentHash<Node<String>> consistentHash = new ConsistentHash<>(iHashService, 500, nodes);

        for (int i = 0; i < 5000; i++) {
            String data = UUID.randomUUID().toString() + i;
            Node<String> node = consistentHash.get(data);
            map.put(node.getIp(), map.get(node.getIp()) + 1);
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println(IP_PREFIX + i + "节点记录条数：" + map.get(IP_PREFIX + i));
        }

    }
}
