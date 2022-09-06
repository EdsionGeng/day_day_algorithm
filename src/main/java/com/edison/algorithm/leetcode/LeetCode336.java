package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
//
//示例 1:
//
//输入: [“abcd”,“dcba”,“lls”,“s”,“sssll”]
//输出: [[0,1],[1,0],[3,2],[2,4]]
//解释: 可拼接成的回文串为 [“dcbaabcd”,“abcddcba”,“slls”,“llssssll”]
//示例 2:
//
//输入: [“bat”,“tab”,“cat”]
//输出: [[0,1],[1,0]]
//解释: 可拼接成的回文串为 [“battab”,“tabbat”]
//
//PS:
//字符串反转构建字典树，再判定当前字符串在字典树中是否存在，如存在则证明存在其他串的子串镜像和该串相等，定义子串平均长度为k，则复杂度为O(N * K ^ 2)
//————————————————
//版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/a1439775520/article/details/104737344
public class LeetCode336 {
    private static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        LeetCode336 le = new LeetCode336();
        le.palindromeParis(words);
        for (List<Integer> list : ans) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> palindromeParis(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        ans = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            find(root, words[i], i);
        }
        return ans;
    }

    private static class TrieNode {
        int index;
        TrieNode[] next;
        List<Integer> palindIndex;

        public TrieNode() {
            index = -1;
            next = new TrieNode[26];
            palindIndex = new ArrayList<>();
        }
    }

    private static void find(TrieNode root, String word, int index) {
        for (int i = 0; i < word.length(); i++) {
            if (root.index != -1 && root.index != index && isPalindrome(word, i, word.length() - 1)) {
                ans.add(Arrays.asList(index, root.index));
            }
            if (root.next[word.charAt(i) - 'a'] == null) {
                return;
            }
            root = root.next[word.charAt(i) - 'a'];

        }
        for (int i : root.palindIndex) {
            if (i != index) {
                ans.add(Arrays.asList(index, i));
            }
        }
    }

    private static void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int ch = word.charAt(i) - 'a';
            if (root.next[ch] == null) {
                root.next[ch] = new TrieNode();
            }
            if (isPalindrome(word, 0, i)) {
                root.palindIndex.add(index);
            }
            root = root.next[ch];
        }
        root.index = index;
        root.palindIndex.add(index);
    }

    private static boolean isPalindrome(String str, int l, int r) {
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
