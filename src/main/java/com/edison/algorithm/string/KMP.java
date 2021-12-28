package com.edison.algorithm.string;


/**
 * 描述:
 * KMP字符串算法 BF 暴力匹配算法
 *
 * @author gengyongchang
 * @create 2020-05-14 17:51
 */
public class KMP {

    public static int[] kmpnext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(j) != dest.charAt(i)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int kmp(String str, String dest) {
        int[] next = kmpnext(dest);
        for (int i = 0, j = 0; i < str.length(); i++) {
            while (j > 0 && str.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (str.charAt(i) == dest.charAt(j)) {
                j++;
            }
            if (j == dest.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }


    /**
     * 暴力匹配
     *
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

    //    public static void main(String[] args) {
//        String[] needle = {"a", "b", "c", "a", "b", "e", "a", "b", "d"};
//        String[] hayStack = {"a", "b", "d"};
//        int result = BFSearch(hayStack, needle);
//        System.out.println(result);
//
//    }
    public static void main(String[] args) {
        String a = "ABACABAD";
        String b = "BBC ABACABACABAD ABCDABDE";
        int result = kmp(b, a);

        //打印结果：和字符串获得匹配的位置
        System.out.println("resultPosition:" + result);
    }
}