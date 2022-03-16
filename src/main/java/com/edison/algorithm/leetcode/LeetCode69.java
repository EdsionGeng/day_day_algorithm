package com.edison.algorithm.leetcode;

/**
 * 描述:
 * X的平方根
 *
 * @author gengyc
 * @create 2022-01-17 11:10
 */
public class LeetCode69 {
    public int mySqrt(int x) {
        System.out.println(0x5f3759df);
        long t = x;
        t = 0x5f3759df - (t >> 1);
        while (!(t * t <= x && (t + 1) * (t + 1) > x)) {
            t = (x / t + t) / 2;
        }
        return (int)t;
    }

    public static void main(String[] args) {
        LeetCode69 leetCode69=new LeetCode69();
        leetCode69.mySqrt(8);
    }
}