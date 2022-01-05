package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 字符串查找
 *
 * @author gengyc
 * @create 2022-01-04 16:00
 */
public class LeetCode28 {
    public int strStr(String source, String target) {
        if (target == null || target.length() == 0) return 0;
        int[] next = new int[target.length()];
        getNext(target, next);
        int i = 0, j = 0;
        while (i < source.length() && j < target.length()) {
            if (j == -1 || source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];

            }
        }
        if (j == target.length()) {
            return i - j;
        }
        return -1;

    }

    private void getNext(String target, int[] next) {
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < target.length() - 1) {
            if (j == -1 || target.charAt(i) == target.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
    }

}