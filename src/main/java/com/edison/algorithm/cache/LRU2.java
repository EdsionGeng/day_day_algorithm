package com.edison.algorithm.cache;

import sun.misc.LRUCache;

import java.util.LinkedHashMap;

public class LRU2 extends LRU {
    private int k;
    private LRU historyList;

    public LRU2(int maxSize, int historyCapacity, int k) {
        super(maxSize);
        this.k = k;
        this.historyList = new LRU(historyCapacity);
    }
}
