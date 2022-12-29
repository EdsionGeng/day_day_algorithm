package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 求逆波兰式表达值
 *
 * @author gengyc
 * @create 2022-02-16 10:20
 */
public class LeetCode150 {
    int index;

    public int evalRPN(String[] tokens) {
        index = tokens.length - 1;
        return getPrefix(tokens);
    }

    public int getPrefix(String[] tokens) {
        String token = tokens[index--];
        if (token.equals("+")) {
            int prefix1 = getPrefix(tokens);
            int prefix0 = getPrefix(tokens);
            return prefix0 + prefix1;
        } else if (token.equals("-")) {
            int prefix1 = getPrefix(tokens);
            int prefix0 = getPrefix(tokens);
            return prefix0 - prefix1;
        } else if (token.equals("*")) {
            int prefix1 = getPrefix(tokens);
            int prefix0 = getPrefix(tokens);
            return prefix0 * prefix1;
        } else if (token.equals("/")) {
            int prefix1 = getPrefix(tokens);
            int prefix0 = getPrefix(tokens);
            return prefix0 / prefix1;
        } else {
            return Integer.parseInt(token);
        }

    }

    public static void main(String[] args) {
        LeetCode150 le = new LeetCode150();
        System.out.println(le.evalRPN(new String[]{"2","1","+","3","*"}));
    }

}