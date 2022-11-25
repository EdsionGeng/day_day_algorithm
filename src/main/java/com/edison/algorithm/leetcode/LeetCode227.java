package com.edison.algorithm.leetcode;

public class LeetCode227 {

    public int calculate(String s) {
        int i = 0;
        return parseExpr(s, 0);
    }

    public int parseExpr(String s, int i) {
        char op = '+';
        int left = 0, right = 0;

        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                int n = parseNum(s, i);
                switch (op) {
                    case '+':
                        left += right;
                        right = n;
                        break;
                    case '-':
                        left += right;
                        right = -n;
                        break;
                    case '*':
                        right *= n;
                        break;
                    case '/':
                        right /= n;
                        break;
                }
                if (i < s.length()) {
                    op = s.charAt(i);
                }
            }
            ++i;
        }
        return left + right;
    }

    public int parseNum(String s, int i) {
        int n = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            n = 10 * n + (s.charAt(i++) - '0');
        }
        return n;
    }

    public static void main(String[] args) {
        LeetCode227 le = new LeetCode227();

        int res = le.calculate("3+5/2");
        System.out.println(res);
    }

}
