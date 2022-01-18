package com.edison.algorithm.struct;

/**
 * 描述:
 * 线段树
 *
 * @author gengyc
 * @create 2022-01-18 16:16
 */
public class LineSignTree<E> {
    public interface Merger<E> {
        E merger(E num1, E num2);
    }

    E[] data;
    E[] treeData;
    Merger<E> merger;

    LineSignTree(E[] data, Merger merger) {
        this.data = data;
        this.merger = merger;
        int height = (int) Math.ceil((Math.log(data.length)) / Math.log(2)) + 1;
        treeData = (E[]) new Object[(int) Math.pow(2, height) - 1];
        buildLineSignTree(0, data.length - 1, 0);
    }

    private void buildLineSignTree(int start, int end, int index) {
        if (start == end) {
            treeData[index] = data[start];
            return;
        }

        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        int mid = start + (end - start) / 2;
        buildLineSignTree(start, mid, leftIndex);
        buildLineSignTree(mid + 1, end, rightIndex);
        treeData[index] = merger.merger(treeData[leftIndex], treeData[rightIndex]);
    }

    public E query(int start, int end, int index, int from, int to) {
        if (start == from && end == to) {
            return treeData[index];
        }
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        int midIndex = start + (end - start) / 2;
        if (from > midIndex) {
            return query(midIndex + 1, end, rightIndex, from, to);
        } else if (to <= midIndex) {
            return query(start, midIndex, leftIndex, from, to);
        } else {
            return merger.merger(query(start, midIndex, leftIndex, from, midIndex),
                    query(midIndex + 1, end, rightIndex, midIndex + 1, to));
        }
    }

    public void update(int start, int end, int index, int oriIndex, E value) {
        if (start == end) {
            treeData[index] = data[oriIndex] = value;
            return;
        }
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        int midIndex = start + (end - start) / 2;
        if (oriIndex <= midIndex) {
            update(start, midIndex, leftIndex, oriIndex, value);
        } else {
            update(midIndex + 1, end, rightIndex, oriIndex, value);
        }
        treeData[index] = merger.merger(treeData[leftIndex], treeData[rightIndex]);
    }

}