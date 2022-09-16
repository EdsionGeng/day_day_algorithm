package com.edison.algorithm.leetcode;


//字符串排列 写一个函数s2是否包含s1的排列
public class LeetCode567 {

    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[128];
        for (char s : s1.toCharArray()) {
            count[s]++;
        }
        int low = 0, high = 0;
        while (high < s2.length()) {
            if (count[s2.charAt(high)] > 0) {
                count[s2.charAt(high++)]--;
                if (high - low == s1.length()) {
                    return true;
                }
            } else {
                count[s2.charAt(low++)]++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode567 le = new LeetCode567();
        System.out.println(le.checkInclusion("ab", "eidboaoo"));
    }
}
