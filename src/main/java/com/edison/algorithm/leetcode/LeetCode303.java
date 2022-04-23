package com.edison.algorithm.leetcode;

/**
 * @Description TODO
 * @Date 2022/4/21下午6:36
 * @Created by edsiongeng
 */
public class LeetCode303 {
    //给定一个整数数组 nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i, j 两点。
    //
    //示例：
    //
    //给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
    //
    //sumRange(0, 2) -> 1
    //sumRange(2, 5) -> -1
    //sumRange(0, 5) -> -3
    //说明:
    //
    //你可以假设数组不可变。
    //会多次调用 sumRange 方法。
    //
    //
    //————————————————
    //版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/a1439775520/article/details/104681777

    class NumArray {
        private int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length];
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] += sums[i - 1] + nums[i];

            }
        }

        public int sum(int i, int j) {
            if (i == 0) {
                return sums[j];
            } else {
                return sums[j] - sums[i - 1];
            }
        }
    }
}
