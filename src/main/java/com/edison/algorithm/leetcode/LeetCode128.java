package com.edison.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述:
 * 最长连续序列
 *
 * @author gengyc
 * @create 2022-01-28 14:56
 */
public class LeetCode128 {
//给定一个未排序的整数数组，找出最长连续序列的长度。
//
//要求算法的时间复杂度为 O(n)。
//
//示例:
//
//输入: [100, 4, 200, 1, 3, 2]
//输出: 4
//解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums
        ) {
            set.add(num);
        }
        int longest = 0;
        for (Integer num : nums) {
            if (set.remove(num)) {
                int current = num;
                int currentLongest = 1;
                while (set.remove(current - 1)) {
                    current--;
                }
                currentLongest += num - current;
                current = num;
                while (set.remove(current + 1)) {
                    current++;
                }
                currentLongest += current - num;
                longest = Math.max(longest, currentLongest);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LeetCode128 le = new LeetCode128();
        le.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
    }
}