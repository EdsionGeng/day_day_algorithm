package com.edison.algorithm.leetcode;

/**
 * 最大单词长度乘积
 */
public class LeetCode318 {

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] wordsBit = new int[n];
        for (int i = 0; i < n; i++) {
            wordsBit[i] = convertWordToBit(words[i]);

        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if ((wordsBit[i] & wordsBit[j]) == 0) {
                    int newLength = words[i].length() * words[j].length();
                    max = max < newLength ? newLength : max;
                }
            }
        }
        return max;
    }

    private int convertWordToBit(String word) {
        int wordBit = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            wordBit = wordBit | (1 << (word.charAt(i) - 'a'));
        }
        return wordBit;
    }

    public static void main(String[] args) {

    }
}
