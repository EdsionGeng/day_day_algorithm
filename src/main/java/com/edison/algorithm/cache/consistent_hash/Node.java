package com.edison.algorithm.cache.consistent_hash;

import lombok.Data;

@Data
public class Node<T> {
    private String ip;
    private String name;
    public Node(String ip, String name) {
        this.ip = ip;
        this.name = name;
    }
    @Override
    public String toString() {
        return ip;
    }
}
