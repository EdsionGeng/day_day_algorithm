package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 最大间距
 *
 * @author gengyc
 * @create 2022-02-23 14:57
 */
public class LeetCode164 {
//给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
//
//如果数组元素个数小于 2，则返回 0。
//
//示例 1:
//
//输入: [3,6,9,1]
//输出: 3
//解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
//示例 2:
//
//输入: [10]
//输出: 0
//解释: 数组元素个数小于 2，因此返回 0。

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        double min = nums[0];
        double max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) return 0;
        Bucket[] buckets = new Bucket[nums.length];
        int gap = (int) Math.ceil((max - min) / (nums.length - 1));

        for (int i = 0; i < nums.length; i++) {
            int index = getBucketIndex((int) min, nums[i], gap);
            putInBucket(buckets, nums[i], index);
        }
        int maxGap = buckets[0].max - buckets[0].min;
        int pre = buckets[0].max;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i] != null) {
                if (buckets[i].min - pre > maxGap) {
                    maxGap = buckets[i].min - pre;
                }
                pre = buckets[i].max;
            }
        }
        return maxGap;
    }

    class Bucket {
        int max = 0;
        int min = 0;
   //     boolean hasNum = false;
    }

    public int getBucketIndex(int min, int num, int gap) {
        return (int) (num - min) / gap;
    }

    public void putInBucket(Bucket[] buckets, int num, int index) {
        if (buckets[index] == null) {
            buckets[index] = new Bucket();
         //   buckets[index].hasNum = true;
            buckets[index].max = num;
            buckets[index].min = num;
        }
        if (num > buckets[index].max) {
            buckets[index].max = num;
        }
        if (num < buckets[index].min) {
            buckets[index].min = num;
        }
    }

    public static void main(String[] args) {
        LeetCode164 le = new LeetCode164();
        System.out.println(le.maximumGap(new int[]{3, 6, 9, 1}));
    }
}