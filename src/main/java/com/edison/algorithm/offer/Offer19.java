package com.edison.algorithm.offer;


//正则表达式匹配  同leetcode10
public class Offer19 {

    public boolean isMatch(String src, String pattern) {
        int n = src.length();
        int m = pattern.length();
        boolean[][] f = new boolean[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    if (pattern.charAt(j - 1) != '*') {

                    } else {

                    }

                }

            }
        }
        return f[n][m];
    }

    public boolean isMatch2(String A, String B) {
        if (A.length() == 0) {
            if (B.length() % 2 != 0) return false;
            int i = 1;
            while (i < B.length()) {
                if (B.charAt(i) != '*') return false;
                i += 2;
            }
            return true;
        }
        if (B.length() == 0) return false;
        char c1 = A.charAt(0), c2 = B.charAt(0), c3 = 'a';
        if (B.length() > 1) c3 = B.charAt(1);
        if (c3 != '*') {
            if (c1 == c2 || c2 == '.') {
                return isMatch2(A.substring(1), B.substring(1));
            } else {
                return false;
            }
        } else {
            if (c1 == c2 || c2 == '.') {

                return isMatch2(A.substring(1), B) || isMatch2(A, B.substring(2));
            } else {
                return isMatch2(A, B.substring(2));
            }
        }
    }

    public static void main(String[] args) {
        Offer19 o = new Offer19();
        System.out.println(o.isMatch2("","b*"));

    }
}
