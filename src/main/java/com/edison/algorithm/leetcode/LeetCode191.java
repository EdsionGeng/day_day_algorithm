package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 位1的个数
 *
 * @author gengyc
 * @create 2022-03-01 10:32
 */
public class LeetCode191 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count++;
            n >>>= 1;
        }
        Integer.bitCount(n);
        return count;
    }

}