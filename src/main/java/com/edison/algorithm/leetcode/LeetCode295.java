package com.edison.algorithm.leetcode;

import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @Description 数据流的中位数
 * @Date 2022/4/17下午4:07
 * @Created by edsiongeng
 */
public class LeetCode295 {
    //295. 数据流的中位数
    //中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
    //
    //例如，
    //
    //[2,3,4] 的中位数是 3
    //
    //[2,3] 的中位数是 (2 + 3) / 2 = 2.5
    //
    //设计一个支持以下两种操作的数据结构：
    //
    //void addNum(int num) - 从数据流中添加一个整数到数据结构中。
    //double findMedian() - 返回目前所有元素的中位数。
    //示例：
    //
    //addNum(1)
    //addNum(2)
    //findMedian() -> 1.5
    //addNum(3)
    //findMedian() -> 2
    //进阶:
    //
    //如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
    //如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
    //————————————————
    //版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/a1439775520/article/details/104677830

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public LeetCode295() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a, b) -> b - a);

    }

    public void addNum(int num) {
        min.add(num);
        if (min.size() > max.size()) {
            max.add(min.remove());
        }
    }

    public double findMedian() {
        if (min.size() == max.size()) {
            return (max.peek() + min.peek()) / 2.0;
        }
        return max.peek();
    }

    public static void main(String[] args) {
        LeetCode295 le = new LeetCode295();
        le.addNum(2);
        le.addNum(3);
        System.out.println(le.findMedian());
        le.addNum(4);
        System.out.println(le.findMedian());
        le.addNum(5);
        System.out.println(le.findMedian());
    }

}
