package com.edison.algorithm.leetcode;

//三元表达式解析器
public class LeetCode439 {

    public String parseTernary(String expression) {
        int n = expression.length();
        int checkLevel = 0;
        for (int i = 1; i < n; i++) {
            if (expression.charAt(i) == '?') checkLevel++;
            if (expression.charAt(i) == ':') checkLevel--;
            if (checkLevel == 0)
                return (expression.charAt(0) == 'T') ? parseTernary(expression.substring(2, i)) : parseTernary(expression.substring(i + 1, n));
        }
        return expression;

    }

    public static void main(String[] args) {
        LeetCode439 le = new LeetCode439();
        System.out.println(le.parseTernary("T?2:3"));
    }
}
