package com.edison.algorithm.struct;

/**
 * @Description 哈希链地址法
 * @Date 2020/3/6上午12:07
 * @Created by edsiongeng
 */

public class HashChain {

    private SortLink[] hashArray;//数组中存放链表
    private int arraySize;

    public HashChain(int size) {
        arraySize = size;
        hashArray = new SortLink[arraySize];
        //new 出每个空链表初始化数据
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new SortLink();
        }
    }

    public void displayTable() {
        for (int i = 0; i < arraySize; i++) {
            System.out.println(i + ":");
            hashArray[i].displayLink();
        }
    }

    public int hashFunction(int key) {
        return key % arraySize;
    }

    public void insert(SortLink.LinkNode node) {
        int key = node.getKey();
        int hashVal = hashFunction(key);
        hashArray[hashVal].insert(node);//直接往链表添加
    }


    public SortLink.LinkNode delete(int key) {
        int hashVal = hashFunction(key);
        SortLink.LinkNode temp = find(key);
        hashArray[hashVal].delete(key);
        return temp;
    }

    public SortLink.LinkNode find(int key) {
        int hashVal = hashFunction(key);
        SortLink.LinkNode node = hashArray[hashVal].find(key);
        return node;
    }

}
