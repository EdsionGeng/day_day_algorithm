package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 复原IP地址
 *
 * @author gengyc
 * @create 2022-01-21 14:33
 */
public class LeetCode93 {
    //给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//
//示例:
//
//输入: “25525511135”
//输出: [“255.255.11.135”, “255.255.111.35”]
    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddress(String s) {
        if (s.length() < 4) {
            return res;
        }
        backtrack(s, 0, new StringBuilder(), 0);
        return res;
    }

    private void backtrack(String s, int start, StringBuilder sb, int pointNumOfSb) {
        if (pointNumOfSb > 4) { //大于三个点，则剪枝，这里大于4是因为最后一次还会加一
            return;
        }
        if (start == s.length() && pointNumOfSb == 4) {
            res.add(sb.toString().substring(1));
            return;
        }
        //i-start<3 如果大于三位数则返回
        for (int i = start; i < s.length() && i - start < 3; i++) {
            String x = s.substring(start, i + 1);
            if (x.charAt(0) == '0' && x.length() > 1) {//如果是0xx这种则返回
                return;
            }
            if (Integer.parseInt(x) <= 255) {
                sb.append("." + x);
                backtrack(s, i + 1, sb, pointNumOfSb + 1);
                sb.delete(sb.lastIndexOf("."), sb.length());
            }
        }

    }

    public static void main(String[] args) {
        LeetCode93 le = new LeetCode93();
        le.restoreIpAddress("25525511135");
    }
}