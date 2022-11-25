package com.edison.algorithm.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 单词搜索 {


    public static boolean wordBreak(String s, List<String> wordDict) {

        return dfs(s, wordDict, new HashSet<>(), 0);
    }

    public static boolean dfs(String s, List<String> wordDict, Set<Integer> indexSet, int startIndex) {
        if (startIndex == s.length()) return true;
        for (int i = startIndex; i <= s.length(); i++) {
            if (indexSet.contains(i)) continue;

            if (wordDict.contains(s.substring(startIndex, i))) {
                if (dfs(s, wordDict, indexSet, i)) return true;
                indexSet.add(i);
            }
        }
        return false;

    }
    public static boolean wordBreak2(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0]=true;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i+1; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i + 1))) {
                    dp[i+1] = true;
                }
            }
        }
        return dp[length];
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");

        System.out.println(wordBreak2("catsanddog", list));

    }


}
