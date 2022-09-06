package com.edison.algorithm.leetcode;

//392. 判断子序列 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
//字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
//
//示例 1:
//s = “abc”, t = “ahbgdc”
//返回 true.
//
//示例 2:
//s = “axc”, t = “ahbgdc”
//返回 false.
//
//后续挑战 :
//如果有大量输入的 S，称作S1, S2, … , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
//
//解题思路
//逻辑分析：
//
//1. 子问题
//在该问题中，子问题为s字符串中的每个字符与t串的匹配关系，即可划分为n = len(s)个子问题。
//
//2. 转移方程
//遍历s字符串，在t字符串中寻找相应的字符，当寻找到了一个s中的字符时即意味着解决了一个子问题，当所有s字符串中的所有字符都找到了的时候（即完成寻找时，寻找的次数小于等于t字符串的长度），可以认为s字符串为t字符串的子串。
//————————————————
//版权声明：本文为CSDN博主「huahuayaaaa」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/weixin_44637878/article/details/107067414
public class LeetCode392 {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) return false;
        }
        return true;
    }

    public boolean isSubsequence2(String s, String t) {
        t = " " + t;
        int n = t.length();
        int[][] dp = new int[26][n];
        for (char ch = 0; ch < 26; ch++) {
            int p = -1;
            for (int i = n - 1; i >= 0; i--) {
                dp[ch][i] = p;
                if (t.charAt(i) == ch + 'a') p = i;
            }
        }
        int i = 0;
        for (char ch : s.toCharArray()) {
            i = dp[ch - 'a'][i];
            if (i == -1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        LeetCode392 le = new LeetCode392();
        le.isSubsequence2(s, t);

    }
}
