package com.edison.algorithm.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//至多包含两个不同字符的最长子串长度
//input s="eceba" out:3 ""ece  input“ccaabbb" out：5 aabbb
public class LeetCode159 {


    public int lengthOfLongestSubstringTwoDistinct(String s) {

        int len = s.length();
        if (len < 3) {
            return len;
        }
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 2;
        while (r < len) {
            if (map.size() < 3) {
                map.put(s.charAt(r), r++);
            }
            if (map.size() == 3) {
                int delIndex = Collections.min(map.values());
                map.remove(s.charAt(delIndex));
                l = delIndex + 1;
            }
            maxLen = Math.max(maxLen, r - l);
        }
        return maxLen;

    }

    public static void main(String[] args) {
        LeetCode159 le = new LeetCode159();
        le.lengthOfLongestSubstringTwoDistinct("eceba");
    }
}
