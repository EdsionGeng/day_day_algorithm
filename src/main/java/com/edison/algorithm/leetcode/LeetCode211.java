package com.edison.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 描述:
 * 添加与搜索单词
 *
 * @author gengyc
 * @create 2022-03-09 14:02
 */
public class LeetCode211 {
    Map<Integer, Set<String>> map = new HashMap<>();

    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        int length = word.length();
        if (map.get(length) != null) {
            map.get(length).add(word);
        } else {
            Set<String> set = new HashSet<>();
            set.add(word);
            map.put(length, set);
        }
    }

    public boolean search(String word) {
        Set<String> set = map.get(word.length());
        if (set == null) return false;
        if (set.contains(word)) return true;
        char[] chars = word.toCharArray();
        P:
        for (String s : set) {
            if (word.length() != s.length()) {
                continue;
            }
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if (chars[i] != '.' && chars[i] != cs[i]) {
                    continue P;
                }
            }
           // set.add(word);
            return true;
        }
        return false;
    }

}