package com.edison.algorithm.leetcode;

//不同字符的最小子序列
public class LeetCode1081 {

    public String smallestSubSequence(String s) {

        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        boolean[] visited = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!visited[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (nums[sb.charAt(sb.length() - 1)-'a'] > 0) {
                        visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                visited[ch - 'a'] = true;
                sb.append(ch);
            }
            nums[ch - 'a']--;

        }

        return sb.toString();

    }

    public static void main(String[] args) {
        LeetCode1081 le = new LeetCode1081();
        System.out.println(le.smallestSubSequence("cbacdcbc"));
    }
}
