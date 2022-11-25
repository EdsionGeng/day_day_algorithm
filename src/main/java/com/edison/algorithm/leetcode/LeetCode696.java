package com.edison.algorithm.leetcode;

//给定０－１字符串，输出一个整数。求多少非空子０－１字符串数量相同
public class LeetCode696 {
    public int countBinarySubstrings(String s) {
        int pre = 0, cur = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ++cur;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) {
                ++count;
            }
        }
        return count;
    }


}
