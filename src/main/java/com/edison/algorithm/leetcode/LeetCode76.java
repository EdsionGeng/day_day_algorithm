package com.edison.algorithm.leetcode;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 描述:
 * 最小覆盖子串
 *
 * @author gengyc
 * @create 2022-01-17 17:21
 */
public class LeetCode76 {
    //给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
//
//示例：
//
//输入: S = “ADOBECODEBANC”, T = “ABC”
//输出: “BANC”
//说明：
//
//如果 S 中不存这样的子串，则返回空字符串 “”。
//如果 S 中存在这样的子串，我们保证它是唯一的答案。
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] auxT = new int[128];
        for (int i = 0; i < t.length(); i++) {
            auxT[t.charAt(i)]++;
        }
        int[] auxS = new int[128];
        for (int i = 0; i < t.length(); i++) {
            auxS[s.charAt(i)]++;
        }
        int start = 0, end = t.length(), min = Integer.MAX_VALUE, startIndex = 0;
        while (end <= s.length()) {
            while (check(auxS, auxT)) {
                if (end - start < min) {
                    min = end - start;
                    startIndex = start;
                }
                auxS[s.charAt(start++)]--;
            }
            if (end <= s.length() - 1) {
                auxS[s.charAt(end++)]++;
            } else {
                break;
            }
        }
        return min != Integer.MAX_VALUE ? s.substring(startIndex, startIndex + min) : "";
    }

    Map<Character, Integer> ori = new HashMap<>();
    Map<Character, Integer> cnt = new HashMap<>();

    public String minWindow2(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            ori.put(t.charAt(i), ori.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            r++;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check2() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = 1;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);

    }

    public String minWindow3(String s, String t) {
        int[] chars = new int[128];
        boolean[] flag = new boolean[128];

        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i)]++;
            flag[t.charAt(i)] = true;
        }
        int cnt = 0, l = 0, minL = 0, minSize = s.length();
        for (int r = 0; r < s.length(); r++) {
            if (flag[s.charAt(r)]) {
                if (--chars[s.charAt(r)] >= 0) {
                    ++cnt;
                }
                while (cnt == t.length()) {
                    if (r - l + 1 < minSize) {
                        minL = l;
                        minSize = minL+r - l + 1;
                    }
                    if (flag[s.charAt(l)] && ++chars[s.charAt(l)] > 0) {
                        --cnt;
                    }
                    ++l;
                }
            }

        }
        return minSize > s.length() ? "" : s.substring(minL, minSize);
    }

    public boolean check2() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }

        }
        return true;
    }

    private boolean check(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] < nums2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode76 leetCode76 = new LeetCode76();
        System.out.println(leetCode76.minWindow3("ADOBECODEBANCE", "ABC"));

    }
}