package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 整数反转
 *
 * @author gengyc
 * @create 2021-12-23 14:11
 */
public class LeetCode7 {
    public static int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        long rs = 0;

        while (x != 0) {
            rs = rs * 10 + x % 10;
            x/=10;
        }
        return Integer.valueOf((rs > max || rs < min ? 0 : rs) + "");
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

}