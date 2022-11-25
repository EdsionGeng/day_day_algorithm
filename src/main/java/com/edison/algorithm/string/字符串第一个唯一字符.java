package com.edison.algorithm.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class 字符串第一个唯一字符 {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1) {
                return entry.getKey();
            }
        }
        return -1;

    }

}
