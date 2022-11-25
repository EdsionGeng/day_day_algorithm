package com.edison.algorithm.leetcode;

public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode14 le = new LeetCode14();
        System.out.println(le.longestCommonPrefix(new String[]{"flower", "flower", "floweright"}));
    }
}
