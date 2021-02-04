package com.edison.algorithm.struct;

import java.util.NoSuchElementException;

public class MyLoopQueue<T> {
    private T[] array;
    private int begin;
    private int len;
    private int end;



    public MyLoopQueue(int capacity) {
        array = (T[]) new Object[capacity];
        len = capacity;
        begin = 0;
        end = 0;
    }

    public MyLoopQueue() {
        this(10);
    }

    public void add(T element) {
        if (isFull()) {
            throw new NoSuchElementException("queue is full");
        }
        array[end++] = element;
        end = end == len ? 0 : end;
        //不能在add(element)里面直接动态扩容的原因：
        //问题出在这一句，如果添加到最后一个下标，end将==0。但是下一次调用add(element)时，
        // 会将element放入0的位置，并覆盖之前的所有数据
    }

    public T remove() {

        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty!");
        }
        T answer = array[begin];
        array[begin++] = null;
        begin = begin == len ? 0 : begin;
        return answer;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == len;
    }

    public int size() {
        if (end == begin) {
            return array[begin] == null ? 0 : len;
        } else if (end > begin) {
            return end - begin;
        } else {
            return end + len - begin;
        }
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty!");
        }
        return array[begin];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (isEmpty()) {
            sb.append("]");
            return sb.toString();
        }
        for (int i = 0; i < size(); i++) {
            T a = array[(begin + i) % len];
            sb.append(a.toString());
            if (i != size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();

    }

}
