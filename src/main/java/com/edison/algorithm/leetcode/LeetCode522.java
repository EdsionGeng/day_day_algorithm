package com.edison.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

//给定字符串列表，你需要从它们中找出最长的特殊序列。
//最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
//
//子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
//
//输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。
//————————————————
//版权声明：本文为CSDN博主「Michael阿明」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/qq_21201267/article/details/101036485
public class LeetCode522 {

    boolean checkSubSeq(String a, String b) { // 判断字符串a是否是字符串b的子序列
        for (int i = 0, j = 0; i < a.length(); i++,j++) {
            while (j < b.length() && a.charAt(i) != b.charAt(j)) {
                ++j;
            }
            if (j == b.length()) {
                return false;// 如果b走到最后也没有和a匹配完，那么a不是b的子序列
            }
        }
        return true;
    }

    public int findLUSLength(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            if (i + 1 < strs.length && strs[i] == strs[i + 1]) {
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (checkSubSeq(strs[i], strs[j])) {
                    flag = false;
                }
            }
            if (flag) return strs[i].length();
        }
        return -1;

    }

    public static void main(String[] args) {
        LeetCode522 le = new LeetCode522();
        le.findLUSLength(new String[]{"aba", "cdc", "eae"});
    }
}
