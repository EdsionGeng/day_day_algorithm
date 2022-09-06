package com.edison.algorithm.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 最长公共子序列
 *
 * @author gengyc
 * @create 2021-12-06 14:54
 */
public class LCS {
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        int[][] dp = new int[ch1.length + 1][ch2.length + 1];
        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                if (ch1[i] == ch2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[ch1.length][ch2.length];

    }

    public static void main(String[] args) {
//        String str1 = "abcwww";
//        String str2 = "a2b2cee3f";
//        Sy stem.out.println(longestCommonSubsequence(str1, str2));
//        int[] a = new int[]{2, 1, -1};
//        int total = 0;
//        for (int i : a) {
//            total += i;
//        }
//        int sum = 0;
//        for (int i = 0; i < a.length; i++) {
//            if (2 * sum == total - a[i]) {
//                System.out.println(i);
//                return;
//            }
//            sum += a[i];
//        }
        System.out.println(isIsomorphic("badc", "baba"));

    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        char[] src = s.toCharArray();
        char[] target = t.toCharArray();
        for (int i = 0; i < src.length; i++) {
            if (map.containsKey(src[i])) {
                char value = src[i];
                if (target[i] != map.get(value)) {
                    return false;
                }
            } else {
                if (map.containsKey(target[i])) {
                    return false;
                } else {
                    map.put(src[i], target[i]);
                }

            }

        }
        return true;
    }

}