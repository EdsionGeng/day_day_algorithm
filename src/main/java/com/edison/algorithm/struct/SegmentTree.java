package com.edison.algorithm.struct;

/**
 * 描述:
 * 线段树
 *
 * @author gengyc
 * @create 2022-03-11 13:06
 */
public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public interface Merger<E> {
        E merge(E a, E b);
    }

    public SegmentTree(E[] arr, Merger merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        tree = (E[]) new Object[arr.length * 4];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        buildSegmentTree(0, 0, data.length - 1);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index > data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex,  l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    //查询区间，返回区间 [queryL, queryR] 的统计值
    public E query(int queryL, int queryR) {
        //首先进行边界检查
        if (queryL < 0 || queryL > data.length || queryR < 0 || queryR > data.length || queryL > queryR) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    //在以 treeIndex 为根的线段树中 [l,r] 的范围里，搜索区间 [queryL, queryR]
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (queryL > mid) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        }
        if (queryR <= mid) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }

        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    public void update(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        data[index] = e;
        updateTree(0, 0, data.length - 1, index, e);
    }

    private void updateTree(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (index > mid) {
            updateTree(rightTreeIndex, mid + l, r, index, e);
        } else {
            updateTree(leftTreeIndex, l, mid, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{34, 65, 8, 10, 21, 86, 79, 30};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums, new Merger<Integer>() {

            @Override
            public Integer merge(Integer a, Integer b) {
                return Math.max(a, b);
            }
        });
        System.out.println(segTree.query(4, 7));
    }

}