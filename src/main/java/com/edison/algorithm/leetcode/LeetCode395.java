package com.edison.algorithm.leetcode;

import java.util.HashMap;

//至少有K个重复字符的最长子串
public class LeetCode395 {


    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        HashMap<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : counter.keySet()) {
            if (counter.get(c) < k) {
                int res = 0;
                for (String t : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        LeetCode395 le = new LeetCode395();
        System.out.println(le.longestSubstring("ababbcc", 2));

//        String[] s = "ababbc".split("a");
//        for (String a : s
//        ) {
//            System.out.println(a + "->");
//        }
    }
}
