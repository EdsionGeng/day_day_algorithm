package com.edison.algorithm.leetcode;

import java.util.*;

/**
 * 描述:
 * 单词拆分2
 *
 * @author gengyc
 * @create 2022-02-10 10:37
 */
public class LeetCode140 {

    private Map<String, List<String>> cache = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }

    private List<String> dfs(String s, List<String> wordDict, int offset) {
        if (offset == s.length()) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        if (cache.containsKey(s.substring(offset))) {
            return cache.get(s.substring(offset));
        }
        List<String> res = new ArrayList<>();
        for (String word : wordDict) {
            if (word.equals(s.substring(offset, Math.min(s.length(), offset + word.length())))) {
                List<String> next = dfs(s, wordDict, offset + word.length());
                for (String str : next) {
                    res.add((word + " " + str).trim());
                }
            }
        }
        cache.put(s.substring(offset), res);
        return res;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = new String[]{"cats", "dog", "sand", "and", "cat"};
        LeetCode140 le = new LeetCode140();
        List<String> result = le.wordBreak(s, Arrays.asList(wordDict));
        for (String str : result) {
            System.out.println(str);
        }
    }
}