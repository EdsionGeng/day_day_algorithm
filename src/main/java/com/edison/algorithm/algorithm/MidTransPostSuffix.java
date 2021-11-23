package com.edison.algorithm.algorithm;

import java.util.Stack;

/**
 * 描述:
 * 中缀转后缀表达式
 * a+b*c+(d*e+f)*g
 * abc*+de*f+g*+
 *
 * @author gengyongchang
 * @create 2021-07-23 11:25
 */
public class MidTransPostSuffix {

    public int priority(String op) {
        int priority = 0;
        if (op.equals("*") || op.equals("/")) {
            priority = 2;
        } else if (op.equals("+") || op.equals("-")) {
            priority = 1;
        } else if (op.equals("(")) {
            priority = 0;
        }
        return priority;
    }

    /**
     * a+b*c+(d*e+f)*g
     * abc*+de*f+g*+
     *
     * @param midSuffix
     * @param postSuffix
     * @return
     */
    public String convert(String midSuffix, String postSuffix) {
        Stack<String> stack = new Stack();

        for (int i = 0; i < midSuffix.length(); i++) {
            char s = midSuffix.charAt(i);
            if ((s >= '0' && s <= '9') || (s >= 'a' && s <= 'z')) {
                postSuffix += s;
            } else {
                if (stack.isEmpty()) {
                    stack.push(String.valueOf(s));
                } else if (s == '(') {
                    stack.push(String.valueOf(s));
                } else if (s == ')') {
                    while (!stack.peek().equals("(")) {
                        postSuffix += stack.peek();
                        stack.pop();
                    }
                    stack.pop();
                } else {
                    while (priority(String.valueOf(s)) <= priority(stack.peek())) {
                        postSuffix += stack.peek();
                        stack.pop();
                        if (stack.isEmpty()) {
                            break;
                        }
                    }
                    stack.push(String.valueOf(s));
                }
            }
        }
        while (!stack.isEmpty()) {
            postSuffix += stack.peek();
            stack.pop();
        }

        return postSuffix;
    }

    public static void main(String[] args) {
        MidTransPostSuffix midTransPostSuffix = new MidTransPostSuffix();
        String result = midTransPostSuffix.convert("a+b*c+(d*e+f)*g", "");
        System.out.println(result);
    }
}