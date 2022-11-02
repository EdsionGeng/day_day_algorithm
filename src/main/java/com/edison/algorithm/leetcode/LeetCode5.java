package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 最长回文子串
 *
 * @author gengyc
 * @create 2021-12-28 15:39
 */
public class LeetCode5 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            //把回文看成中间的部分全是同一字符，左右部分相对称
            //找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static String longestPalindrome2(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = huiwen(s, i, i);
            String s2 = huiwen(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public static String huiwen(String str, int l, int r) {
        while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }
        return str.substring(l + 1, r);
    }

    public static int findLongest(char[] str, int low, int[] range) {
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
        int ans = high;
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbbe"));

    }

}