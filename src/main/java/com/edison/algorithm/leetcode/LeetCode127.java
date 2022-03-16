package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 描述:
 * 单词接龙
 *
 * @author gengyc
 * @create 2022-01-28 10:37
 */
public class LeetCode127 {
    //给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//每次转换只能改变一个字母。
//转换过程中的中间单词必须是字典中的单词。
//说明:
//
//如果不存在这样的转换序列，返回 0。
//所有单词具有相同的长度。
//所有单词只由小写字母组成。
//字典中不存在重复的单词。
//你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//示例 1:
//
//输入:
//
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return 0;
        HashSet<String> start = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        HashSet<String> dic = new HashSet<>(wordList);
        start.add(beginWord);
        end.add(endWord);
        if (!dic.contains(endWord)) return 0;
        return bfs(start, end, dic, 2);
    }

    public int bfs(HashSet<String> start, HashSet<String> end, HashSet<String> dic, int l) {
        if (start.size() == 0) return 0;
        if (start.size() > end.size()) {
            return bfs(end, start, dic, l);
        }
        dic.removeAll(start);

        HashSet<String> next = new HashSet<>();
        for (String s : start) {
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char tmp = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (tmp == c) {
                        continue;
                    }
                    arr[i] = c;
                    String nstr = new String(arr);
                    if (dic.contains(nstr)) {
                        if (end.contains(nstr)) {
                            return l;
                        } else {
                            next.add(nstr);
                        }
                    }
                }
                arr[i] = tmp;
            }
        }
        return bfs(next, end, dic, l + 1);
    }

    public static void main(String[] args) {
        LeetCode127 le = new LeetCode127();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        le.ladderLength("hit", "cog", list);
    }
}