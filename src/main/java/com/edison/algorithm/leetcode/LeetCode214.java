package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 最短回文串
 *
 * @author gengyc
 * @create 2022-03-09 19:05
 */
public class LeetCode214 {

    public static String shortestPalindrome(String s) {
        StringBuilder r = new StringBuilder(s).reverse();
        String str = s + "#" + r;
        int[] next = next(str);
        String prefix = r.substring(0, r.length() - next[str.length()]);
        return prefix + s;
    }

    // next数组
    //KMP的next[j]=x就是0~x-1与 j-x~j-1 的元素是相同的
    //大概是这样
    private static int[] next(String P) {
        int[] next = new int[P.length() + 1];
        next[0] = -1;
        int k = -1;
        int i = 1;
        //next【k】保存的是我上次相等的时候
        //不相等的时候我就从我上一次相等的时候就行匹配
        //i是快指针，k是慢指针
        while (i < next.length) {
            if (k == -1 || P.charAt(k) == P.charAt(i - 1)) {
                next[i++] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }


}