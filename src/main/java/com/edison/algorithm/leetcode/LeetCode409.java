package com.edison.algorithm.leetcode;

//最长回文子串
public class LeetCode409 {
    //input s="abccccdd
    //output :7 dccaccd
    public int longestPalindRome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        LeetCode409 le = new LeetCode409();
        System.out.println(5/2*2);
        System.out.println(le.longestPalindRome("abcccccdd"));
        System.out.println(le.longestPalindRome("abccccdd"));

    }
}
