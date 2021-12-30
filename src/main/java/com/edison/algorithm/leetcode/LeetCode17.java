package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 电话号码字母组合
 *
 * @author gengyc
 * @create 2021-12-29 15:33
 */
public class LeetCode17 {
    /**
     * 示例:
     * <p>
     * 输入：“23”
     * 输出：[“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf”].
     */
    public static List<String> letterCombineations(String digits) {
        List<String> list = new ArrayList<>();
        int M = digits.length();
        String[] s = new String[M];
        if (s.length == 0) {
            return list;
        }
        for (int i = 0; i < digits.length(); i++) {
            switch (digits.charAt(i)) {
                case '2':
                    s[i] = "abc";
                    break;
                case '3':
                    s[i] = "def";
                    break;
                case '4':
                    s[i] = "ghi";
                    break;
                case '5':
                    s[i] = "jkl";
                    break;
                case '6':
                    s[i] = "mno";
                    break;
                case '7':
                    s[i] = "pqrs";
                    break;
                case '8':
                    s[i] = "tuv";
                    break;
                case '9':
                    s[i] = "wxyz";
                    break;
            }
        }
        list = getStringWithFor(s, 0, list, "");
        return list;
    }

    private static List<String> getStringWithFor(String[] s, int i, List<String> list, String stemp) {
        if (i < s.length - 1) {
            for (int j = 0; j < s[i].length(); j++) {
                getStringWithFor(s, i + 1, list, stemp + s[i].charAt(j));
            }
            i++;
        } else {
            for (int j = 0; j < s[i].length(); j++) {
                list.add(stemp + s[i].charAt(j));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = letterCombineations("246");
        for (String s : list) {
            System.out.println(s);
        }
    }
}