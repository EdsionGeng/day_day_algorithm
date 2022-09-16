package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

//找到字符串所有字母异味词
public class LeetCode438 {


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length(), m = p.length();
        int[] cnt = new int[26];
        for (int i = 0; i < m; i++) {
            cnt[p.charAt(i) - 'a']++;
        }
        int a = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) a++;
        }
        for (int l = 0, r = 0, b = 0; r < n; r++) {
            if (--cnt[s.charAt(r) - 'a'] == 0) b++;
            if (r - l + 1 > m && ++cnt[s.charAt(l++) - 'a'] == 1) b--;
            if (a == b) result.add(l);

        }
        return result;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] cnt = new int[128];
        for (char c : p.toCharArray()) {
            cnt[c]++;
        }
        int low = 0, high = 0;
        while (high < s.length()) {
            if (cnt[s.charAt(high)] > 0) {
                cnt[s.charAt(high++)]--;
                if (high - low == p.length()) result.add(low);
            } else {
                cnt[s.charAt(low++)]++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode438 le = new LeetCode438();
        List<Integer> result = le.findAnagrams2("cbaebabacd", "abc");
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
