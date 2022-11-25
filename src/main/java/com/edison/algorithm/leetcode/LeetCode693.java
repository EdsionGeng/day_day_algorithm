package com.edison.algorithm.leetcode;

//利用位运算判断一个数的二进制是否会出现连续的0和1
public class LeetCode693 {

    boolean hasAlternatingBits(int n) {
        long a = (n ^ n >> 1);

        return (a & a + 1) == 0;
    }

    public static void main(String[] args) {
        LeetCode693 le = new LeetCode693();
        System.out.println(le.hasAlternatingBits(5));
    }
}
