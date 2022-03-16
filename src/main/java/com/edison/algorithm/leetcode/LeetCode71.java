package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 简化路径
 *
 * @author gengyc
 * @create 2022-01-17 14:52
 */
public class LeetCode71 {
    public String simplifyPath(String path) {
        path = "/" + path + "/";
        String[] stack = new String[500];
        int top = -1;
        int i = 0, j = 0;
        char[] ch = path.toCharArray();
        while (i < ch.length && j < ch.length) {
            while (i < ch.length && ch[i] == '/') {
                i++;
            }
            j = i;
            while (j < ch.length && ch[j] != '/') {
                j++;
            }
            if (i == ch.length || j == i) {
                break;
            }
            String cur = path.substring(i, j);
            if ("..".equals(cur)) {
                if (top != -1) --top;
            } else if (".".equals(cur)) {

            } else {
                stack[++top] = cur;
            }
            i = j;
        }
        String res = "/";
        for (int k = 0; k < top; k++) {
            res += stack[k] + "/";
        }
        return res + (top >= 0 ? stack[top] : "");
    }

    public static void main(String[] args) {
        String path = "/home//foo";
        LeetCode71 leetCode71 = new LeetCode71();
        System.out.println(leetCode71.simplifyPath(path));
    }

}