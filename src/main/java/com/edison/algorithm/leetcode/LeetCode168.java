package com.edison.algorithm.leetcode;

/**
 * 描述:
 * Excel列表名称
 *
 * @author gengyc
 * @create 2022-02-28 17:25
 */
public class LeetCode168 {
    //示例 1:
//
//输入: 1
//输出: “A”
//示例 2:
//
//输入: 28
//输出: “AB”
//示例 3:
//
//输入: 701
//输出: “ZY”
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n = n / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        LeetCode168 le = new LeetCode168();
        System.out.println(le.convertToTitle(701));
    }
}