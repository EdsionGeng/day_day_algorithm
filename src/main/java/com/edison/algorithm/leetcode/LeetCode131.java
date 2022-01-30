package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * 分割回文串
 *
 * @author gengyc
 * @create 2022-01-29 10:04
 */
public class LeetCode131 {
//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//
//返回 s 所有可能的分割方案。
//示例:
//输入: “aab”[
//  ["aa","b"],
//  ["a","a","b"]
//]
    int len;
    ArrayList<List<String>> res = new ArrayList<>();
    String s;
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        this.s = s;
        len = s.length();

        if (len < 1)
            return res;

        // dp[i][j] 表示某一子串,s.substring(i, j + 1)
        // 例如 s="babad",dp[0][0] = "b",dp[0][4] = "babad"
        dp = new boolean[len][len];
        // one character
        // 斜着遍历 [0,0] -> [1,1] -> ...
        // 单个字符均为回文
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // two character
        // 斜着遍历 [0,1] -> [1,2] -> ...
        // 两个字符均相同才是回文
        for (int i = 0; i < len - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        // others
        // 开始dp,  此子串 = 字符 + 左下角的子串 + 字符
        // 只有左下角是回文,同时两端添加的字符相同时,才是回文
        for (int i = 2; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                dp[j][j + i] = dp[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
            }
        }
        //回溯法,穿串串
        foo(new LinkedList<>(), 0);
        return res;
    }

    void foo(LinkedList<String> path, int level) {
        if (level == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = level; i < len; i++) {
            if (dp[level][i]) {
                path.add(s.substring(level, i + 1));
                foo(path, i + 1);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        LeetCode131 le = new LeetCode131();
        List<List<String>> result = le.partition("babcac");
    }
}