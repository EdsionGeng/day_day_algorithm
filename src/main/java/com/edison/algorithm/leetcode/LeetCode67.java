package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 二进制求和
 *
 * @author gengyc
 * @create 2022-01-15 14:32
 */
public class LeetCode67 {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        StringBuilder stb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                c += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                c += b.charAt(j--) - '0';
            }
            stb.append(c % 2);
            c >>= 1;
        }
        String res = stb.reverse().toString();
        return c > 0 ? '1' + res : res;
    }

    public static void main(String[] args) {
        LeetCode67 leetCode67 = new LeetCode67();
        System.out.println(leetCode67.addBinary("1010", "1011"));
    }

}