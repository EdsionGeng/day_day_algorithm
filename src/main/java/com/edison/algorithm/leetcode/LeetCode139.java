package com.edison.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 * 单词拆分
 *
 * @author gengyc
 * @create 2022-02-09 17:23
 */
public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> hasCompute = new HashMap();
        return wordBreak(s, wordDict, 0, hasCompute);
    }

    public boolean wordBreak(String s, List<String> wordDict, int index, Map hasCompute) {
        if (s == null || s.length() == 0) return false;
        for (String word : wordDict) {
            if (s.startsWith(word, index)) {
                index += word.length();
                if (hasCompute.containsKey(index)) return false;
                if (index == s.length()) return true;
                if (wordBreak(s, wordDict, index, hasCompute)) return true;
                else {
                    if (!hasCompute.containsKey(index)) {
                        hasCompute.put(index, false);
                    }
                    index -= word.length();
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode139 le = new LeetCode139();
        String s = "applepenapple";
        String[] wordDict = new String[]{"apple", "pen", "sand", "and", "cat"};
        System.out.println(le.wordBreak(s, Arrays.asList(wordDict)));
    }

}