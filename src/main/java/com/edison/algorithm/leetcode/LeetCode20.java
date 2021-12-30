package com.edison.algorithm.leetcode;

import java.util.Stack;

/**
 * 描述:
 * 实现有效括号
 *
 * @author gengyc
 * @create 2021-12-30 11:30
 */
public class LeetCode20 {

    /**
     * 给定一个只包括 ‘(’，’)’，’{’，’}’，’[’，’]’ 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p>
     * 示例 1:
     * <p>
     * 输入: “()”
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: “()[]{}”
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: “(]”
     * 输出: false
     * 示例 4:
     * <p>
     * 输入: “([)]”
     * 输出: false
     * 示例 5:
     * <p>
     * 输入: “{[]}”
     * 输出: true
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        for (char i : c) {
            if (i == '{') {
                stack.push('}');
            } else if (i == '[') {
                stack.push(']');
            } else if (i == '(') {
                stack.push(')');
            } else if (stack.isEmpty() || i != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
}