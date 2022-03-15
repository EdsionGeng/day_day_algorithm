package com.edison.algorithm.leetcode;

import java.util.*;

/**
 * 描述:
 * 单词搜索2
 *
 * @author gengyc
 * @create 2022-03-09 14:50
 */
public class LeetCode212 {
    //给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
//
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
//
//示例:words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
    class TrieNode {
        private static final int ALPHABET = 26;
        TrieNode[] children = new TrieNode[ALPHABET];
        // 判断这个前缀是不是某个字符串的结尾
        boolean isEndOfWord = false;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET; i++) {
                children[i] = null;
            }
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curNode = root;
            int index;
            for (int i = 0; i < word.length(); i++) {
                index = word.charAt(i) - 'a';
                if (curNode.children[index] == null) {
                    curNode.children[index] = new TrieNode();
                }
                curNode = curNode.children[index];
            }
            curNode.isEndOfWord = true;
        }
    }

    class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            List<String> result = new ArrayList<>();
            if (words == null || words.length == 0 || board == null || board.length == 0 || board[0].length == 0) {
                return result;
            }
            Trie trie = new Trie();
            for (String temp : words) {
                trie.insert(temp);
            }
            TrieNode root = trie.root;
            boolean[][] visited = new boolean[board.length][board[0].length];
            Set<String> tempResult = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (root.children[board[i][j] - 'a'] != null) {
                        dfs(board, visited, i, j, root.children[board[i][j] - 'a'], tempResult, sb);
                    }
                }
            }
            Iterator<String> iterator = tempResult.iterator();
            while (iterator.hasNext()) {
                result.add(iterator.next());
            }
            return result;
        }

        private void dfs(char[][] board, boolean[][] visited, int startIInBoard, int startJInBoard, TrieNode curNode, Set<String> resultSet, StringBuilder curStrBuilder) {
            curStrBuilder.append(board[startIInBoard][startJInBoard]);
            visited[startIInBoard][startJInBoard] = true;
            if (curNode.isEndOfWord) {
                resultSet.add(curStrBuilder.toString());
            }
            if (startIInBoard > 0 && !visited[startIInBoard - 1][startJInBoard] && curNode.children[board[startIInBoard - 1][startJInBoard] - 'a'] != null) {
                dfs(board, visited, startIInBoard - 1, startJInBoard, curNode.children[board[startIInBoard - 1][startJInBoard] - 'a'], resultSet, curStrBuilder);
            }
            // 向下搜索
            if (startIInBoard < board.length - 1 && !visited[startIInBoard + 1][startJInBoard]
                    && curNode.children[board[startIInBoard + 1][startJInBoard] - 'a'] != null) {
                dfs(board, visited, startIInBoard + 1, startJInBoard
                        , curNode.children[board[startIInBoard + 1][startJInBoard] - 'a'], resultSet, curStrBuilder);
            }
            // 向左搜索
            if (startJInBoard > 0 && !visited[startIInBoard][startJInBoard - 1]
                    && curNode.children[board[startIInBoard][startJInBoard - 1] - 'a'] != null) {
                dfs(board, visited, startIInBoard, startJInBoard - 1
                        , curNode.children[board[startIInBoard][startJInBoard - 1] - 'a'], resultSet, curStrBuilder);
            }
            // 向右搜索
            if (startJInBoard < board[0].length - 1 && !visited[startIInBoard][startJInBoard + 1]
                    && curNode.children[board[startIInBoard][startJInBoard + 1] - 'a'] != null) {
                dfs(board, visited, startIInBoard, startJInBoard + 1
                        , curNode.children[board[startIInBoard][startJInBoard + 1] - 'a'], resultSet, curStrBuilder);
            }
            // 恢复现场
            curStrBuilder.setLength(curStrBuilder.length() - 1);
            visited[startIInBoard][startJInBoard] = false;
        }

    }
}