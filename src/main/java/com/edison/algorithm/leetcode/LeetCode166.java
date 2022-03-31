package com.edison.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 分数到小数
 *
 * @author gengyc
 * @create 2022-02-25 17:12
 */
public class LeetCode166 {
//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
//
//如果小数部分为循环小数，则将循环的部分括在括号内。
//
//示例 1:
//
//输入: numerator = 1, denominator = 2
//输出: “0.5”
//示例 2:
//
//输入: numerator = 2, denominator = 1
//输出: “2”
//示例 3:
//
//输入: numerator = 2, denominator = 3
//输出: “0.(6)”

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0 || denominator == 0) return "0";
        int sign = 1;
        if (numerator > 0 && denominator < 0) sign = -1;
        if (numerator < 0 && denominator > 0) sign = -1;

        long big = (long) numerator / (long) denominator;
        long small = numerator % denominator;
        StringBuilder result = new StringBuilder(String.valueOf(big));
        if (sign == -1) result.insert(0, "-");
        if (small != 0) {
            result.append(".");
            StringBuilder smallStr = new StringBuilder();
            Map<String, Integer> smallIndexs = new HashMap<>();
            while (small != 0) {
                small *= 10;
                big = small / denominator;
                small = small % denominator;
                String str = small + "_" + big;
                if (smallIndexs.containsKey(str)) {
                    smallStr.append(")");
                    smallStr.insert(smallIndexs.get(str), "(");
                    break;
                } else {
                    smallIndexs.put(str, smallStr.length());
                    smallStr.append(Math.abs(big));
                }
            }
            result.append(smallStr);
        }
        return result.toString();

    }

    public static void main(String[] args) {
        LeetCode166 le = new LeetCode166();
        System.out.println(le.fractionToDecimal(-1,2));
    }
}