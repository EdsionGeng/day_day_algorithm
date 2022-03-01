package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 数字范围按位与
 *
 * @author gengyc
 * @create 2022-03-01 16:27
 */
public class LeetCode201 {
    //给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
//
//示例 1:
//
//输入: [5,7]
//输出: 4
//示例 2:
//
//输入: [0,1]
//输出: 0
    public int rangeBitwisedAnd(int m, int n) {
        while (m < n) n &= n - 1;
        return n;
    }

    public static void main(String[] args) {
        LeetCode201 le = new LeetCode201();
        le.rangeBitwisedAnd(5, 7);
    }
}