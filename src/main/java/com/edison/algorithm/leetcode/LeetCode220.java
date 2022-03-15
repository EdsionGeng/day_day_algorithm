package com.edison.algorithm.leetcode;

import java.util.TreeSet;

/**
 * 描述:
 * 存在重复元素3
 *
 * @author gengyc
 * @create 2022-03-14 16:29
 */
public class LeetCode220 {
    //给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
//
//示例 1:
//
//输入: nums = [1,2,3,1], k = 3, t = 0
//输出: true
//示例 2:
//
//输入: nums = [1,0,1,1], k = 1, t = 2
//输出: true
//示例 3:
//
//输入: nums = [1,5,9,1,5,9], k = 2, t = 3
//输出: false
//————————————————
//版权声明：本文为CSDN博主「南     墙」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/a1439775520/article/details/104557083
    public boolean example(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= ((long) nums[i] + (long) t)) {
                return true;
            }
            set.add((long) nums[i]);
            if (set.size() == k + 1) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

}