package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 罗马数字转整数
 *
 * @author gengyc
 * @create 2021-12-28 14:51
 */
public class LeetCode13 {
    static int[] binary = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] chars = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static int romanToInt(String s) {
        String tmp;
        int index = 0, end, sum = 0;
        for (int i = 0; i < chars.length; i++) {
            tmp = chars[i];
            end = index + tmp.length();
            while (end <= s.length() && s.substring(index, end).equals(tmp)) {
                sum += binary[i];
                index = end;
                end = index + tmp.length();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}