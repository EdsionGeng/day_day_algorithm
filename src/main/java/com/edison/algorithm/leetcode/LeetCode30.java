package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 描述:困难
 * 串联所有单词的子串
 *
 * @author gengyc
 * @create 2022-01-04 16:46
 */
public class LeetCode30 {
    /**
     * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
     * <p>
     * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * s = “barfoothefoobarman”,
     * words = [“foo”,“bar”]
     * 输出：[0,9]
     * 解释：
     * 从索引 0 和 9 开始的子串分别是 “barfoo” 和 “foobar” 。
     * 输出的顺序不重要, [9,0] 也是有效答案。
     * 示例 2：
     * <p>
     * 输入：
     * s = “wordgoodgoodgoodbestword”,
     * words = [“word”,“good”,“best”,“word”]
     * 输出：[]
     * ————————————————
     */
    public List<Integer> findSubString(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < one_word; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();
            while (right + one_word <= s.length()) {
                String w = s.substring(right, right + one_word);
                right += one_word;
                if (!map.containsKey(w)) {
                    count = 0;
                    left = right;
                    tmp_map.clear();
                } else {
                    tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                    count++;
                    while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                        String t_w = s.substring(left, left + one_word);
                        count--;
                        tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                        left += one_word;
                    }
                    if (count == word_num) res.add(left);
                }
            }
        }
        return res;
    }

    public List<Integer> find(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<>();
        int word = words[0].length();
        int wordNum = words.length;
        for (int i = 0; i < word; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();
            while (right + word < s.length()) {
                String w = s.substring(right, right + word);
                right += word;
                if (!map.containsKey(w)) {
                    left = right;
                    tmp_map.clear();
                    count = 0;
                } else {
                    tmp_map.put(w, map.getOrDefault(w, 0) + 1);
                    count++;
                    while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                        String t_w = s.substring(left, left + word);
                        count--;
                        tmp_map.put(t_w, tmp_map.get(t_w) - 1);
                        left = left + word;
                    }
                    if (count == wordNum) {
                        res.add(left);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode30 leet = new LeetCode30();
        //leet.findSubString("barfoothefoobarman", new String[]{"foo", "bar"});
        leet.findSubString("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"});
    }
}