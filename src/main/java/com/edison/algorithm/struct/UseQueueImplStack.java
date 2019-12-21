package com.edison.algorithm.struct;

import com.sun.javafx.geom.Edge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述:
 * 使用两个队列实现栈
 *
 * @author gengyongchang
 * @create 2019-12-07 15:31
 */
public class UseQueueImplStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int count;

    public UseQueueImplStack() {
        this.queue1 = new LinkedList();
        this.queue2 = new LinkedList<>();
        this.count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void push(Integer value) {
        queue1.add(value);
        count++;
    }

    public Integer pop() {
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }
        count--;
        int result = queue1.remove();
        while (!queue2.isEmpty()) {
            queue1.add(queue2.remove());
        }
        return result;
    }

    public static void main(String[] args) {
        UseQueueImplStack stack = new UseQueueImplStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}