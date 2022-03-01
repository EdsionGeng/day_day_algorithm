package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 翻转字符串里面的单词
 *
 * @author gengyc
 * @create 2022-02-22 18:56
 */
public class LeetCode151 {
    //示例 1：
//
//输入: “the sky is blue”
//输出: “blue is sky the”
//示例 2：
//
//输入: " hello world! "
//输出: “world! hello”
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//示例 3：
//
//输入: “a good example”
//输出: “example good a”
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//
//说明：
//
//无空格字符构成一个单词。
//输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
    public String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");
        StringBuffer res = new StringBuffer();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].equals("")) {
                continue;
            }
            res.append(s1[i]);
            if (i > 0) {
                res.append(" ");
            }
        }
        return res.toString();
    }
}