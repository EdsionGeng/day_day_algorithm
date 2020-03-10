package com.edison.algorithm.struct;

/**
 * @Description 用双端链表实现队列
 * @Date 2020/3/1下午10:41
 * @Created by edsiongeng
 */
public class QueueLinkedList {

    private DoublePointLinkedList dp;

    public QueueLinkedList() {
        dp = new DoublePointLinkedList();
    }

    public void insert(Object data) {
        dp.addTail(data);
    }

    public void delete() {
        dp.deleteHead();
    }

    public boolean isEmpty() {
        return dp.isEmpty();
    }
}
