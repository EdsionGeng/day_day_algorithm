package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 2的幂
 *
 * @author gengyc
 * @create 2022-03-25 15:57
 */
public class LeetCode231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

}