package com.edison.algorithm.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LeetCode340 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        if (len < k) return 0;
        int left = 0, right = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < len) {
            map.put(s.charAt(right), right);
            right++;
            if (map.size() > k) {
                int min = Collections.min(map.values());
                map.remove(s.charAt(min));
                left = min + 1;
            }
            ans = Math.max(ans, right - left);

        }
        return ans;

    }

    public static void main(String[] args) {
        LeetCode340 le = new LeetCode340();
        System.out.println(le.lengthOfLongestSubstringKDistinct("ecebaaaa", 2));
    }


}
