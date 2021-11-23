package com.edison.algorithm.string;

/**
 * 描述:
 * Rabin-Krap字符串算法
 *
 * @author gengyc
 * @create 2021-11-18 17:03
 */
public class RKMatch {


    public static int strRK(String s, String t) {
        int table[] = {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
                47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        //质数表对应a-z
        int n = s.length(), m = t.length(), hashVal, value = 0;
        for (int i = 0; i < m; ++i) {
            value += table[t.charAt(i) - 'a'];
        }
        for (int i = 0; i < n - m + 1; ++i) {
            hashVal = 0;
            for (int j = i; j < i + m; ++j) {
                hashVal += table[s.charAt(j) - 'a'];
            }
            if (value == hashVal && s.charAt(i) == t.charAt(0)) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "efgbcefgdcabc";
        String t = "efg";
        System.out.println(strRK(s, t));
    }
}