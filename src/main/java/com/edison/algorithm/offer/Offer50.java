package com.edison.algorithm.offer;

import org.apache.commons.collections4.map.LinkedMap;

import java.util.LinkedHashMap;
import java.util.Map;

//第一个只出现一次的字符
public class Offer50 {

    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {

            map.put(c, !map.containsKey(c));

        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        Offer50 offer50 = new Offer50();
        System.out.println(offer50.firstUniqChar("abaccdeff"));
    }
}
