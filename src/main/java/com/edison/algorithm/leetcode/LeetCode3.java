package com.edison.algorithm.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * @Description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * @Date 2020/6/4下午11:03
 * @Created by edsiongeng
 */
public class LeetCode3 {

//abcabcd

    //
    public static void main(String[] args) {
        String s="abcdabcdjklmv";
        System.out.println(lengthOflongestSubStringHashMap(s));
    }

    public static int lengthOflongestSubStringHashMap(String s) {
        if (s == null || s.length() == 0) return 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end))+1 );
            }
            map.put(s.charAt(end), end);
            maxLength = Math.max(maxLength, end - start + 1);

        }
        return maxLength;

    }


}
