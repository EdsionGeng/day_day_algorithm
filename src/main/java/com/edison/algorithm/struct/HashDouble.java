package com.edison.algorithm.struct;

/**
 * @Description 哈希表
 * @Date 2020/3/5下午10:59
 * @Created by edsiongeng
 */
public class HashDouble {//再哈希法
    private DataItem[] hashArray;
    private int arraySize;
    private int itemNum;
    private DataItem nonItem;

    public HashDouble() {
        this.arraySize = 13;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
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
                System.out.print("** ");
            }
        }
    }

    public int hashFunction1(int key) {
        return key % arraySize;
    }

    public int hashFuncton2(int key) {
        return 5 - key % 5;
    }

    public void insert(DataItem item) {
        if (isFull()) {
            System.out.println("hashTable is full,need to rehash");
            extendHashTable();
        }
        int key = item.getKey();
        int hashVal = hashFunction1(key);
        int stepSize = hashFuncton2(key);
        //用第二个哈希函数计算探测步骤
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
        itemNum++;
    }

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
            System.out.println("hashTable is empty");
            return null;
        }
        int hashVal = hashFunction1(key);
        int stepSize = hashFuncton2(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                itemNum--;
                return temp;

            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunction1(key);
        int stepSize = hashFuncton2(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            hashVal += stepSize;
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
