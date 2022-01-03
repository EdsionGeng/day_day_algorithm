package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 回文数
 *
 * @author gengyc
 * @create 2021-12-27 15:48
 */
public class LeetCode9 {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        //578
        int rem = 0, y = 0, quo = x;
        while (quo != 0) {
            rem = quo % 10;
            y = y * 10 + rem;
            quo = quo / 10;
            //y=5 57
        }
        return y == x;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(575));
    }

}