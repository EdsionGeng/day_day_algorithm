package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
//
//列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
//
//示例 1:
//
//输入: [[1,1],2,[1,1]]
//输出: [1,1,2,1,1]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
//示例 2:
//
//输入: [1,[4,[6]]]
//输出: [1,4,6]
//解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
//————————————————
//版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/a1439775520/article/details/104738100
public class LeetCode341 implements Iterator<Integer> {
    private List<Integer> list = new ArrayList<>();
    private int index;


    private void add(List<NestedInteger> nestedList) {
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                list.add(nest.getInteger());
            } else {
                add(nest.getList());
            }
        }

    }

    public LeetCode341(List<NestedInteger> list) {
        add(list);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Integer next() {
        return list.get(index++);
    }

    interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }
}
