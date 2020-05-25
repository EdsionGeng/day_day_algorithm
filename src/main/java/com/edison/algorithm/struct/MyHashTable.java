package com.edison.algorithm.struct;

import java.net.ServerSocket;

/**
 * @Description 哈希表
 * @Date 2020/3/5下午10:28
 * @Created by edsiongeng
 */
public class MyHashTable {//线性探测

    ServerSocket

    private DataItem[] hashArray;//DataItem类，表示每个数据项信息
    private int arraySize;//数组初识大小
    private int itemNum;//数组实际存储多少数据
    private DataItem nonItem;//用于删除数据项

    public MyHashTable(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);//删除数据项下标为-1
    }


    public boolean isFull() {
        return itemNum == arraySize;
    }

    public boolean isEmpty() {
        return itemNum == 0;
    }

    public void display() {
        System.out.println("Table:");
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null) {
                System.out.print(hashArray[i].getKey() + " ");
            } else {
                System.out.print("**");
            }
        }
    }

    public int hashFunction(int key) {
        return key % arraySize;
    }

    public void insert(DataItem item) {
        if (isFull()) {
            System.out.println("hashTable is full,ned to rehash");
            extendHashTable();
        }
        int key = item.getKey();
        int hashVal = hashFunction(key);
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
        itemNum++;
    }

    /**
     * 数组有固定的大小，而且不能扩展，所以扩展哈希表只能另外创建一个更大的数组，然后把旧数组中的数据插到新的数组中。
     * 但是哈希表是根据数组大小计算给定数据的位置的，所以这些数据项不能再放在新数组中和老数组相同的位置上。
     * 因此不能直接拷贝，需要按顺序遍历老数组，并使用insert方法向新数组中插入每个数据项。
     * 这个过程叫做重新哈希化。这是一个耗时的过程，但如果数组要进行扩展，这个过程是必须的。
     */
    public void extendHashTable() {
        int num = arraySize;
        itemNum = 0;
        arraySize *= 2;
        DataItem[] oldHashArray = hashArray;
        hashArray = new DataItem[arraySize];
        for (int i = 0; i < num; i++) {
            insert(oldHashArray[i]);
        }
    }

    public DataItem delete(int key) {
        if (isEmpty()) {
            System.out.println("Hash Table isEmpty");
            return null;
        }
        int hashVal = hashFunction(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;//表示为空，key-1;
                itemNum--;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunction(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }


    private static class DataItem {
        private int iData;

        public DataItem(int iData) {
            this.iData = iData;
        }

        public int getKey() {
            return iData;
        }
    }
}
