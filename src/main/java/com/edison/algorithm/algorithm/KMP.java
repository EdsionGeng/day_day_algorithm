package com.edison.algorithm.algorithm;



/**
 * 描述:
 * KMP字符串算法 BF 暴力匹配算法
 *
 * @author gengyongchang
 * @create 2020-05-14 17:51
 */
public class KMP {

    /**
     * 暴力匹配
     * @param hayStack
     * @param needle
     * @return
     */

    public static int BFSearch(String[] hayStack, String[] needle) {
        int l1 = hayStack.length;
        int l2 = needle.length;
        int i = 0, j = 0;
        while (i < l1 && j < l2) {
            if (hayStack[i] == needle[j]) {
                i++;
                j++;
            } else {
                i -= j - 1;
                j = 0;
            }
        }
        if (j == l2) {
            return i - j;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] needle = {"a", "b", "c", "a", "b", "e","a", "b", "d"};
        String[] hayStack = {"a", "b", "d"};
        int result = BFSearch(hayStack, needle);
        System.out.println(result);

    }
}