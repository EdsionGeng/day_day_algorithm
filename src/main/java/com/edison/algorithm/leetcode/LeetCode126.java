package com.edison.algorithm.leetcode;

import java.util.*;

/**
 * 描述:
 * 单词接龙2
 *
 * @author gengyc
 * @create 2022-01-28 13:20
 */
public class LeetCode126 {
    //给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
//
//每次转换只能改变一个字母。
//转换过程中的中间单词必须是字典中的单词。
//说明:
//
//如果不存在这样的转换序列，返回一个空列表。
//所有单词具有相同的长度。
//所有单词只由小写字母组成。
//字典中不存在重复的单词。
//你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList == null) {
            return res;
        }
        Set<String> dicts = new HashSet<>(wordList);
        if (!dicts.contains(endWord)) {
            return res;
        }
        if (dicts.contains(beginWord)) {
            dicts.remove(beginWord);
        }
        Set<String> endList = new HashSet<>(), beginList = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();
        beginList.add(beginWord);
        endList.add(endWord);

        bfs(map, beginList, endList, beginWord, endWord, dicts, false);
        List<String> subList = new ArrayList<>();
        subList.add(beginWord);
        dfs(map, res, subList, beginWord, endWord);
        return res;
    }

    void dfs(Map<String, List<String>> map, List<List<String>> result, List<String> subList, String
            beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(subList));
            return;
        }
        if (!map.containsKey(beginWord)) {
            return;
        }
        for (String word : map.get(beginWord)) {
            subList.add(word);
            dfs(map, result, subList, word, endWord);
            subList.remove(subList.size() - 1);
        }
    }

    void bfs(Map<String, List<String>> map, Set<String> beginList, Set<String> endList, String
            beginWord, String endWord, Set<String> wordList, boolean reverse) {
        if (beginList.size() == 0) {return;}
        wordList.removeAll(beginList);
        boolean finish = false;
        Set<String> temp = new HashSet<>();
        for (String str : beginList) {
            char[] chars = str.toCharArray();
            for (int chI = 0; chI < chars.length; chI++) {
                char old = chars[chI];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == old) {continue;}
                    chars[chI] = ch;
                    String newstr = new String(chars);
                    if (!wordList.contains(newstr)) {
                        continue;
                    }
                    if (endList.contains(newstr)) {
                        finish = true;
                    } else {
                        temp.add(newstr);
                    }
                    String key = reverse ? newstr : str;
                    String value = reverse ? str : newstr;
                    if (!map.containsKey(key)) {
                        map.put(key, new ArrayList<>());
                    }
                    map.get(key).add(value);
                }
                chars[chI] = old;

            }
        }
        if (!finish) {
            if (temp.size() > endList.size()) {
                bfs(map, endList, temp, beginWord, endWord, wordList, !reverse);
            } else {
                bfs(map, temp, endList, beginWord, endWord, wordList, reverse);
            }

        }

    }
}