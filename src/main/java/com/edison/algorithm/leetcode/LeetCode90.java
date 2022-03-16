package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 * 子集2
 *
 * @author gengyc
 * @create 2022-01-20 15:17
 */
public class LeetCode90 {
    //给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//说明：解集不能包含重复的子集。
//
//示例:
//
//输入: [1,2,2]
//输出:
//[
//[2],
//[1],
//[1,2,2],
//[2,2],
//[1,2],
//[]
//]先进行排序，保证重复元素挨在一起
//记录每次遍历生成的新序列的长度，这里用left表示每次遍历的开始位置，right结束位置，len表示长度
//根据与前面元素是否重复，来决定left的取值，也就是开始遍历的位置
//
//其实和子集1还是差不多的
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        retList.add(new ArrayList<>());
        if (nums == null || nums.length == 0) return retList;
        Arrays.sort(nums);

        List<Integer> tmp = new ArrayList<>();
        tmp.add(nums[0]);
        retList.add(tmp);
        if (nums.length == 1) {
            return retList;
        }
        int lastLen = 1;
        for (int i = 2; i < nums.length; i++) {
            int size = retList.size();
            if (nums[i] != nums[i - 1]) {
                lastLen = size;
            }
            for (int j = size - lastLen; j < size; j++) {
                List<Integer> inner = new ArrayList<>(retList.get(j));
                inner.add(nums[i]);
                retList.add(inner);
            }
        }
        return retList;
    }

}