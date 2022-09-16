package com.edison.algorithm.leetcode;

//替换后最长重复字符 输入 s=ABAB k=2 输出 4 用两个A替换两个B
//s=AABABBA k=1 output=4

public class LeetCode424 {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len < 2) return len;
        char[] arr = s.toCharArray();
        int left = 0, right = 0, res = 0, maxCount = 0;
        int[] freq = new int[26];
        //left->right最多替换k个字符串得到只有一种字符的子串
        while (right < len) {
            freq[arr[right] - 'A']++;
            maxCount = Math.max(maxCount, freq[arr[right] - 'A']);
            right++;
            if (right - left > maxCount + k) {
                //说明此时k不够用
                freq[arr[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode424 le = new LeetCode424();
        System.out.println(le.characterReplacement("AABABBA", 1));
        System.out.println(0.1+0.2);
    }
}
