package com.edison.algorithm.dp;

public class 段式回文 {

    public static int longestDecomposition(String text) {
        int n = text.length();
        int left = 0, right = n - 1;
        int len = 1, count = 0;

        while (left < right && len <= right - left) {
            String leftStr = text.substring(left, left + len);
            String rightStr = text.substring(right - len + 1, right + 1);
            if (leftStr == rightStr) {
                count = count + 2;
                left = left + len;
                right = right - len;
                len = 1;
            } else {
                len = len + 1;
            }
        }
        if (left == right + 1) {
            return count;
        }
        return count + 1;
    }

    public static void main(String[] args) {
        System.out.println(longestDecomposition("merchantm"));
    }
}
