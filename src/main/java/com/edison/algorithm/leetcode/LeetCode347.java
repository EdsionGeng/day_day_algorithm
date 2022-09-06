package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//前 K 个高频元素
//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
//示例 1:
//
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//示例 2:
//
//输入: nums = [1], k = 1
//输出: [1]
//说明：
//
//你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
//你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
//————————————————
//版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/a1439775520/article/details/104745653
public class LeetCode347 {

    public List<Integer> topKFrequent(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();
        int distinctLen = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                distinctLen++;
            }
        }
        int[] order = new int[distinctLen];
        int[] counts = new int[distinctLen];
        int index = 0, count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                counts[index] = count;
                order[index] = count;
                nums[index] = nums[i - 1];
                index++;
                count = 1;
            }
        }
        nums[index] = nums[nums.length - 1];
        counts[index] = count;
        order[index] = count;
        Arrays.sort(order);
        int kth = order[distinctLen - k];
        for (int i = 0; i < index; i++) {
            if (counts[i] >= kth) {
                list.add(nums[i]);
            }
        }
        return list;
    }

}
