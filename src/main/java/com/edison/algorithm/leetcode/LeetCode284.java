package com.edison.algorithm.leetcode;

import java.util.Iterator;

/**
 * @Description 顶端迭代器
 * @Date 2022/4/17下午2:14
 * @Created by edsiongeng
 */
public class LeetCode284 implements Iterator<Integer> {
    //给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器 – 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
    //
    //示例:
    //
    //假设迭代器被初始化为列表 [1,2,3]。
    //
    //调用 next() 返回 1，得到列表中的第一个元素。
    //现在调用 peek() 返回 2，下一个元素。在此之后调用 next() 仍然返回 2。
    //最后一次调用 next() 返回 3，末尾元素。在此之后调用 hasNext() 应该返回 false。
    //进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？
    //————————————————
    //版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/a1439775520/article/details/104671006


    private Iterator<Integer> iterator;

    private Integer cache = null;

    public LeetCode284(Iterator iterator) {
        this.iterator = iterator;
    }

    public int peek() {
        if (cache == null) {
            cache = iterator.next();
        }
        return cache;
    }

    @Override
    public boolean hasNext() {
        return cache != null || iterator.hasNext();
    }

    @Override
    public Integer next() {
        if (cache == null) {
            return iterator.next();
        }
        Integer temp = cache;
        cache = null;
        return temp;
    }
}
