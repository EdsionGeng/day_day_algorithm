package com.edison.algorithm.struct;

/**
 * @Description 链表实现栈功能
 * @Date 2020/3/1下午10:16
 * @Created by edsiongeng
 */
public class StackSingleLink {

    private SingleLinkedList singleLinkedList;

    public StackSingleLink() {
        singleLinkedList = new SingleLinkedList();
    }

    public void push(Object obj) {
        singleLinkedList.addHead(obj);
    }

    public Object pop() {
        Object o = singleLinkedList.deleteHead();

        return o;
    }

    public boolean isEmpty() {
        return singleLinkedList.isEmpty();
    }

    public void display() {
        singleLinkedList.display();
    }

}
