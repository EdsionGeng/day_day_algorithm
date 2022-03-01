package com.edison.algorithm.leetcode;

/**
 * 描述:
 * Excel表列序号
 *
 * @author gengyc
 * @create 2022-02-28 17:52
 */
public class LeetCode171 {
    public int titleToNumber(String s) {
        char[] charArray = s.toCharArray();
        int res = 0;
        for (int i = 0; i < charArray.length; i++) {
            res = res * 26 + (charArray[i] - 'A' + 1);
        }
        return res;
    }
}