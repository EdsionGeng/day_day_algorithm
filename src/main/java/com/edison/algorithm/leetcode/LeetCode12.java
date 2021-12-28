package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 整数转罗马数字
 *
 * @author gengyc
 * @create 2021-12-28 14:42
 */
public class LeetCode12 {
    private static int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    private static String[] strings = new String[]{
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num >= nums[i]) {
                sb.append(strings[i]);
                num = num - nums[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
    }
}