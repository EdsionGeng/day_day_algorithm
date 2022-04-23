package com.edison.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 单词规律
 * @Date 2022/4/17下午3:37
 * @Created by edsiongeng
 */
public class LeetCode290 {

    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        int len = pattern.length();
        if (len != strs.length) return false;
        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char tmp = pattern.charAt(i);
            if (map.containsKey(tmp)) {
                if (!map.get(tmp).equals(strs[i])) return false;
            } else {
                if (map.containsValue(strs[i])) {
                    return false;
                } else {
                    map.put(tmp, strs[i]);
                }
            }
        }
        return true;
    }
}
