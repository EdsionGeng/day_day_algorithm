package com.edison.algorithm.struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 描述:
 * Trie前缀树
 *
 * @author gengyongchang
 * @create 2020-05-12 11:43
 */
public class Trie {
    private Node root;
    private int size;

    private List<String> list = new ArrayList<>();

    public int genSize() {
        return size;
    }

    public Trie() {
        this.root = new Node();
        size = 0;
    }

    public void addBranchInTrie(String word) {
        Node cur = root;
        char[] words = word.toCharArray();
        for (char c : words) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Node());
            }
            cur = cur.children.get(c);
        }
        if (!cur.isLeaf) {
            cur.isLeaf = true;
            size++;
        }
    }

    public boolean contains(String word) {
        Node cur = root;
        char[] words = word.toCharArray();
        for (char c : words) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.isLeaf;
    }

    public String sensitiveWordReplace(String word) {
        System.out.println("敏感词替换前：" + word);

        Node cur = root;
        char[] words = word.toCharArray();
        StringBuilder oldTemp = new StringBuilder();
        StringBuilder starTemp = new StringBuilder();
        for (char c : words) {
            if (!cur.children.containsKey(c)) {
                continue;
            }
            if (!cur.isLeaf) {
                oldTemp.append(c);
                starTemp.append("*");
                cur = cur.children.get(c);
            }
            if (cur.isLeaf) {
                //replace
                word = word.replaceAll(oldTemp.toString(), starTemp.toString());
                oldTemp.delete(0, oldTemp.length());
                starTemp.delete(0, starTemp.length());
                cur = root;
            }
        }
        System.out.println("敏感词替换后：" + word);
        return word;
    }

    public void prefixMatching(String word, Node root) {
        Node cur = root;
        char[] words = word.toCharArray();
        StringBuilder str = new StringBuilder();
        str.append(word);
        for (int i = 0; i < words.length; i++) {
            if (!cur.children.containsKey(words[i])) {
                System.out.println("无关联词");
                return;
            }
            cur = cur.children.get(words[i]);
        }
        dfs(str, cur);
        System.out.println("[" + word + "] 在trie树中的联想词：" + Arrays.toString(list.toArray()));
    }

    public void dfs(StringBuilder word, Node root) {
        Node cur = root;
        if (cur.isLeaf) {
            list.add(word.toString());
            if (cur.children.size() == 0) {
                return;
            }
        }
        for (Character s : cur.children.keySet()) {
            word.append(s);
            dfs(word, cur.children.get(s));
            word.delete(word.length() - 1, word.length());
        }
    }

    public static void main(String[] args) {
//        Trie t = new Trie();
//        t.addBranchInTrie("麻痹");
//        t.addBranchInTrie("尼玛的");
//        t.addBranchInTrie("狗日的");
//        // 插入联想词
//        t.addBranchInTrie("联想云科技");
//        t.addBranchInTrie("联盟");
//        t.addBranchInTrie("和利泰扩招了");
//
//        System.out.println("trie树中分枝的个数：" + t.size);
//
//        String word = "尼玛的";
//        System.out.println("Trie树中是否存在[ " + word + " ]敏感词: " + t.contains(word));
//        // 敏感词替换测试
//        t.sensitiveWordReplace("衮，尼玛的傻子，你麻痹的，你各狗日的，早晚揍死你。");
//
//        // trie树实现联想测试
//        t.prefixMatching("联", t.root);
        String[] needle = {"a", "b", "c", "a", "b", "e", "a", "b", "d"};
        String[] hayStack = {"a", "b", "d"};
        int result = KMP(needle, hayStack);
        System.out.println(result);
    }

    private class Node {
        private boolean isLeaf;
        private HashMap<Character, Node> children;

        public Node(boolean isLeaf) {
            this.isLeaf = isLeaf;
            this.children = new HashMap<>();
        }

        public Node() {
            this(false);
        }

    }

    public static int KMP(String[] k1, String[] k2) {
        int i = 0, j = 0, l1 = k1.length, l2 = k2.length;
        while (i < l1 && j < l2) {
            if (k1[i] == k2[j]) {
                i++;
                j++;
            } else {
                i = i-(j - 1);
                j = 0;
            }
        }
        if (j == l2) {
            return i - j;
        }
        return -1;
    }

}