package com.edison.algorithm.leetcode;

/**
 * 描述:
 * x 的 n 次幂函数
 *
 * @author gengyc
 * @create 2022-01-12 15:27
 */
public class LeetCode50 {
    public static int pow(int x, int n) {
        if (n == 1) {
            return x;
        }
        if (n % 2 != 0) {
            return pow(x, n / 2) * pow(x, n / 2) * x;
        }
        return  pow(x, n / 2) * pow(x, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(pow(2,-2));
    }

}