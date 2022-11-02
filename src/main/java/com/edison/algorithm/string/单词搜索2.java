package com.edison.algorithm.string;

import java.util.*;

public class 单词搜索2 {

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    class Trie {
        String word;
        Map<Character, Trie> children;

        public Trie() {
            this.word = "";
            this.children = new HashMap<>();
        }


        public void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new Trie());
                }
                cur = cur.children.get(c);
            }
            cur.word = word;
        }

    }


    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ans = new HashSet<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, trie, i, j, ans);
            }
        }
        return new ArrayList<>(ans);

    }

    public void dfs(char[][] board, Trie now, int i, int j, Set<String> ans) {
        char ch = board[i][j];
        if (!now.children.containsKey(ch)) {
            return;
        }
        Trie next = now.children.get(ch);
        if (!"".equals(next.word)) {
            ans.add(next.word);
            next.word = "";
        }
        if (!next.children.isEmpty()) {
            board[i][j] = '#';
            for (int[] dir : dirs) {
                int i2 = i + dir[0], j2 = j + dir[1];
                if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) {
                    dfs(board, next, i2, j2, ans);
                }
            }
            board[i][j] = ch;
        }
        if (!next.children.isEmpty()) {
            now.children.remove(ch);
        }
    }

    public static void main(String[] args) {
        单词搜索2 le = new 单词搜索2();
        System.out.println(le.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"}));
    }
}
