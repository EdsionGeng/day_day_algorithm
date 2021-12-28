package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 字符串转整数
 *
 * @author gengyc
 * @create 2021-12-23 15:07
 */
public class LeetCode8 {

    public static int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        int sign = 1;
        int start = 0;
        char c = str.charAt(0);
        if (c == '+') {
            sign = 1;
            start++;
        } else if (c == '-') {
            sign = -1;
            start++;
        }
        long res = 0;
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-4193 with words"));
    }
}