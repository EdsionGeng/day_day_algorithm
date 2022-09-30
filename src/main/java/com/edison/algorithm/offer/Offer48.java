package com.edison.algorithm.offer;

import java.util.HashMap;
import java.util.Map;

//最长不含重复字符的长串
public class Offer48 {
    public int lengthOfLongestSubString(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            res = Math.max(res, end - start + 1);

        }
        return res;
    }
}
