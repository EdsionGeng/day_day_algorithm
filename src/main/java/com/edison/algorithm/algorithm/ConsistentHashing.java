package com.edison.algorithm.algorithm;

import java.util.*;

/**
 * @Description 一致性Hash
 * @Date 2022/3/30下午6:43
 * @Created by edsiongeng
 */
public class ConsistentHashing {
    /**
     * 集群节点的机器地址
     */
    public static class Node {
        private String ipAddr;
        private int port;
        private String name;

        public Node(String ipAddr, int port, String name) {
            this.ipAddr = ipAddr;
            this.port = port;
            this.name = name;
        }

        @Override
        public String toString() {
            return name + ":<" + ipAddr + ":" + port + ">";
        }
    }

    private SortedMap<Integer, Node> hashCircle = new TreeMap<>();
    private int virtualNums;


    public ConsistentHashing(Node[] nodes, int virtualNums) {
        this.virtualNums = virtualNums;
        for (Node node : nodes) {
            add(node);
        }
    }

    public void add(Node node) {
        for (int i = 0; i < virtualNums; i++) {
            hashCircle.put(hash(node.toString() + i), node);
        }

    }

    public void remove(Node node) {
        for (int i = 0; i < virtualNums; i++) {
            hashCircle.remove(hash(node.toString() + i));
        }
    }

    public Node getNode(String key) {
        if (key == null || hashCircle.isEmpty()) return null;
        int hash = hash(key);
        if (!hashCircle.containsKey(hash)) {
            SortedMap<Integer, Node> tailMap = hashCircle.tailMap(hash);
            hash = tailMap.isEmpty() ? hashCircle.firstKey() : tailMap.firstKey();
        }
        return hashCircle.get(hash);
    }

    private int hash(String key) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash ^ key.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    public static void main(String[] args) {
        ConsistentHashing.Node[] nodes = new ConsistentHashing.Node[4];
        Map<Node, List<String>> map = new HashMap<>();

        // make nodes 4台服务器节点
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ConsistentHashing.Node("10.1.32.2" + i, 8070, "myNode" + i);
        }

        ConsistentHashing ch = new ConsistentHashing(nodes, 160);

        // make keys 100万个key
        String[] keys = new String[1_000_000];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = "key" + (i + 17) + "ss" + (i * 19);
        }

        // make results
        for (String key : keys) {
            ConsistentHashing.Node n = ch.getNode(key);
            List<String> list = map.computeIfAbsent(n, k -> new ArrayList<>());
            list.add(key);
        }

        // 统计标准差，评估服务器节点的负载均衡性
        int[] loads = new int[nodes.length];
        int x = 0;
        for (Iterator<ConsistentHashing.Node> i = map.keySet().iterator(); i.hasNext(); ) {
            ConsistentHashing.Node key = i.next();
            List<String> list = map.get(key);
            loads[x++] = list.size();
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int load : loads) {
            min = Math.min(min, load);
            max = Math.max(max, load);
        }
        System.out.println("最小值: " + min + "; 最大值: " + max);
        System.out.println("方差：" + variance(loads));
    }

    public static double variance(int[] data) {
        double variance = 0;
        double expect = (double) sum(data) / data.length;
        for (double datum : data) {
            variance += (Math.pow(datum - expect, 2));
        }
        variance /= data.length;
        return Math.sqrt(variance);
    }

    private static int sum(int[] data) {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
    }


}
