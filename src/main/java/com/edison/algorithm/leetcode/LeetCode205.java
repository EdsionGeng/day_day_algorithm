package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 同构字符串
 *
 * @author gengyc
 * @create 2022-03-01 17:49
 */
public class LeetCode205 {

    public boolean isIsomorphic(String s, String t) {
        char[] s2t = new char[127];
        char[] t2s = new char[127];
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s2t[S[i]] != '\0' || t2s[T[i]] != '\0') {
                if (s2t[S[i]] != T[i]) return false;
            } else {
                s2t[S[i]] = T[i];
                t2s[T[i]] = S[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode205 le = new LeetCode205();
        System.out.println(le.isIsomorphic("paper", "title"));
    }
}