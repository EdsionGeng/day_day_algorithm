package com.edison.algorithm.leetcode;

/**
 * 描述:
 * Trie树
 *
 * @author gengyc
 * @create 2022-03-02 14:20
 */
public class LeetCode208 {
    class Trie {
        class Node {
            boolean isWord;
            Node[] next = new Node[26];
        }

        Node root = new Node();

        public Trie() {

        }

        public void insert(String word) {
            Node p = root;
            for (char ch : word.toCharArray()) {
                if (p.next[ch - 'a'] == null) {
                    p.next[ch - 'a'] = new Node();
                }
                p = p.next[ch - 'a'];
            }
            p.isWord = true;
        }

        public boolean search(String word) {
            Node p = root;
            for (char ch : word.toCharArray()) {
                if (p.next[ch - 'a'] == null) {
                    return false;
                }
                p = p.next[ch - 'a'];
            }
            return p.isWord;
        }

        public boolean startsWith(String prefix) {
            Node p = root;
            for (char ch : prefix.toCharArray()) {
                if (p.next[ch - 'a'] == null)
                    return false;
                p = p.next[ch - 'a'];
            }
            return true;
        }
    }
}