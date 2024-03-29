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

    public int longestPalindrome2(String s) {
        int[] arr = new int[128];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }
        int count = 0;
        for (int i : arr) {
            count += (i % 2);
        }
        return count == 0 ? s.length() : (s.length() - count + 1);
    }

    public static void main(String[] args) {
        LeetCode409 le = new LeetCode409();

        System.out.println(le.longestPalindRome("abcccccdd"));
        System.out.println(le.longestPalindRome("abccccdd"));
        System.out.println(le.longestPalindrome2("abcccccdd"));
        System.out.println(le.longestPalindrome2("abccccdd"));

    }
}
