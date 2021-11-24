package com.edison.algorithm.string;

/**
 * 描述:Boyer-Moore算法
 * BM算法
 *
 * @author gengyc
 * @create 2021-11-24 15:39
 */
public class BMMatch {
    public static int pattern(String pattern, String target) {
        int tLen = target.length();
        int pLen = pattern.length();
        if (pLen > tLen) {
            return -1;
        }
        int[] bad_table = build_bad_table(pattern);
        int[] good_table = build_good_table(pattern);
        for (int i = pLen - 1, j; i < tLen; ) {
            System.out.println("跳跃位置：" + i);
            for (j = pLen - 1; target.charAt(i) == pattern.charAt(j); i--, j--) {
                if (j == 0) {
                    System.out.println("match success:" + i);
                    return i;
                }
            }
            System.out.println("good_table:"+good_table[pLen - j - 1]);
            System.out.println("bad_table"+bad_table[target.charAt(i)]);
            i += Math.max(good_table[pLen - j - 1], bad_table[target.charAt(i)]);
        }
        return -1;
    }

    public static int[] build_bad_table(String pattern) {
        int[] bad_table = new int[256];
        for (int i = 0; i < bad_table.length; i++) {
            bad_table[i] = pattern.length();
        }
        for (int i = 0; i < pattern.length() - 1; i++) {
            int k = pattern.charAt(i);
            bad_table[k] = pattern.length() - 1 - i;
        }
        return bad_table;
    }

    public static int[] build_good_table(String pattern) {
        int pLen = pattern.length();
        int[] good_table = new int[pLen];
        int lastPrefixPosition = pLen;
        for (int i = pLen - 1; i >= 0; --i) {
            if (isPrefix(pattern, i + 1)) {
                lastPrefixPosition = i + 1;
            }
            good_table[pLen - i - 1] = lastPrefixPosition - i + pLen - 1;
        }
        for (int i = 0; i < pLen - 1; i++) {
            int slen = suffixLength(pattern, i);
            good_table[slen] = pLen - 1 - i + slen;
        }
        return good_table;

    }

    private static boolean isPrefix(String pattern, int p) {
        int length = pattern.length();
        for (int i = p, j = 0; i < length; i++, j++) {
            if (pattern.charAt(i) != pattern.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private static int suffixLength(String pattern, int p) {
        int length = pattern.length();
        int len = 0;
        for (int i = p, j = length - 1; i >= 0 && pattern.charAt(i) == pattern.charAt(j); i--, j--) {
            len += 1;
        }
        return len;

    }

    public static void main(String[] args) {
        String pattern = "abce";
        String target = "abcdabcdabce";
        System.out.println(pattern(pattern, target));
    }
}