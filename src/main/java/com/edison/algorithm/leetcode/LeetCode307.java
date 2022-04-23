package com.edison.algorithm.leetcode;

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
    }
}
