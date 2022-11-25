package com.edison.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

//给一个数组和字符串，找到数组里有的字符串最长公共子串
//输入 s="abpcplea" ,d=[ale,apple,monkey,plea]
public class LeetCode524 {
    boolean checkSubSeq(String a, String b) {
        for (int i = 0, j = 0; i < a.length(); i++, j++) {
            while (j < b.length() && a.charAt(i) != b.charAt(j)) {
                ++j;
            }
            if (j == b.length()) {
                return false;
            }
        }
        return true;
    }

    public String findLongestWord(String s, String[] d) {
        Arrays.sort(d, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        for (int i = 0; i < d.length; i++) {
            if (checkSubSeq(d[i], s)) {
                return d[i];
            }
        }
        return "";
    }

    public static void main(String[] args) {
        LeetCode524 le = new LeetCode524();
        System.out.println(le.findLongestWord("abpcplea", new String[]{"ale", "apple", "monkey", "plea"

        }));
    }
}
