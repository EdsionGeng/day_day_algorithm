package com.edison.algorithm.leetcode;

import org.omg.CORBA.Object;

import java.util.function.BiFunction;

/**
 * @Description TODO
 * @Date 2022/4/22下午11:47
 * @Created by edsiongeng
 */
public class LeetCode307 {
    //给定一个整数数组 nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i, j 两点。
    //
    //update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
    //
    //示例:
    //
    //Given nums = [1, 3, 5]
    //
    //sumRange(0, 2) -> 9
    //update(1, 2)
    //sumRange(0, 2) -> 8
    //说明:
    //
    //数组仅可以在 update 函数下进行修改。
    //你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
    //PS：
    //线段树
    //————————————————
    //版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/a1439775520/article/details/104685589


    class SegmentTree<E> {
        private E[] data;
        private E[] tree;
        private BiFunction<E, E, E> function;

        public SegmentTree(E[] arr, BiFunction<E, E, E> function) {
            data = (E[]) new Object[arr.length];
            this.function = function;
            System.arraycopy(arr, 0, data, 0, arr.length);
            tree = (E[]) new Object[4 * arr.length];
            buildSegmentTree(0, 0, arr.length - 1);
        }

        private void buildSegmentTree(int index, int left, int right) {
            if (left == right) {
                tree[index] = data[right];
                return;
            }
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);
            int mid = left + (right - left) / 2;
            buildSegmentTree(leftIndex, left, mid);
            buildSegmentTree(rightIndex, mid + 1, right);
            tree[index] = function.apply(tree[leftIndex], tree[rightIndex]);
        }

        public E searchRange(int left, int right) {
            return searchRange(0, 0, data.length - 1, left, right);
        }

        public E searchRange(int rootIndex, int left, int right, int targetLeft, int targetRight) {
            if (targetLeft == left && targetRight == right) {
                return tree[rootIndex];
            }
            int mid = left + (right - left) / 2;
            if (targetLeft > mid) {
                return searchRange(rightChild(rootIndex), mid + 1, right, targetLeft, targetRight);
            }
            if (targetRight <= mid) {
                return searchRange(leftChild(rootIndex), left, mid, targetLeft, targetRight);
            }
            return function.apply(searchRange(leftChild(rootIndex), left, mid, targetLeft, mid),
                    searchRange(rightChild(rootIndex), mid + 1, right, mid + 1, targetRight));
        }

        public void update(int index, E e) {
            if (index < 0 || index >= data.length) {
                throw new IllegalArgumentException("index illegal");
            }
        }

        public void update(int rootIndex, int left, int right, int targetIndex, E e) {
            if (left == right) {
                tree[rootIndex] = e;
                return;
            }
            int mid = left + (right - left) / 2;
            if (targetIndex > mid) {
                update(rightChild(rootIndex), mid + 1, right, targetIndex, e);
            } else {
                update(leftChild(rootIndex), left, mid, targetIndex, e);
            }
            tree[rootIndex] = function.apply(tree[leftChild(rootIndex)], tree[rightChild(rootIndex)]);
        }

        public int leftChild(int root) {
            return root * 2 + 1;
        }

        public int rightChild(int root) {
            return root * 2 + 2;
        }
    }
}
