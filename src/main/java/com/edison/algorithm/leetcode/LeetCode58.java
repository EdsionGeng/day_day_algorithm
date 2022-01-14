package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 最后一个单词长度
 *
 * @author gengyc
 * @create 2022-01-14 14:00
 */
public class LeetCode58 {

    public int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else if (count > 0) {
                return count;
            }
        }
        return count;
    }
}