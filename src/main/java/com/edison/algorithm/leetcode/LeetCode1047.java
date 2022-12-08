package com.edison.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//删除字符串相邻重复项
public class LeetCode1047 {

    public String removeDuplicates(String s) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (top >= 0 && stack.charAt(top) == (ch)) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }

        return stack.toString();

    }

    public static void main(String[] args) {
        LeetCode1047 le = new LeetCode1047();
        le.removeDuplicates("abbaca");
    }
}
