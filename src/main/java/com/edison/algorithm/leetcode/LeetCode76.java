package com.edison.algorithm.leetcode;

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
        System.out.println(leetCode76.minWindow("ADOBECODEBANC", "ABC"));

    }
}