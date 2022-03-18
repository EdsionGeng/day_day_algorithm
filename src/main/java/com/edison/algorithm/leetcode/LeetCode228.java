package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 汇总区间
 *
 * @author gengyc
 * @create 2022-03-18 16:00
 */
public class LeetCode228 {
    //给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
//
//示例 1:
//
//输入: [0,1,2,4,5,7]
//输出: [“0->2”,“4->5”,“7”]
//解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
//示例 2:
//
//输入: [0,2,3,4,6,8,9]
//输出: [“0”,“2->4”,“6”,“8->9”]
//解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
    public List<String> summaryRanges(int[] nums) {
        int low = 0, high = 1;
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;
        while (high <= nums.length) {
            if (high < nums.length && nums[high] == nums[high - 1] + 1) {
                high++;
            } else {
                StringBuilder sb = new StringBuilder();
                if (low == high - 1) {
                    sb.append(nums[low]);
                } else {
                    sb.append(nums[low]).append("->").append(nums[high - 1]);
                }
                result.add(sb.toString());
                low = high;
                high++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode228 le = new LeetCode228();
        List<String> result = le.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
        for (String str : result) {
            System.out.println(str);
        }
    }
}