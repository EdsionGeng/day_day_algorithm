package com.edison.algorithm.leetcode;

import java.util.Stack;

//字符串解码 input 3[a]2[bc] out:aaabcbc
public class LeetCode394 {

    String src;
    int ptr;

    public String decodeString(String s) {
        src = s;
        ptr = 0;
        return getString();
    }

    public String getString() {
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            return "";
        }
        char cur = src.charAt(ptr);
        int repTime = 1;
        String res = "";

        if (Character.isDigit(cur)) {

            repTime = getDigits();
            ++ptr;
            String str = getString();
            ++ptr;
            while (repTime-- > 0) {
                res += str;
            }

        } else if (Character.isLetter(cur)) {
            res = String.valueOf(src.charAt(ptr++));
        }
        return res + getString();

    }

    public int getDigits() {
        int res = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            res = res * 10 + src.charAt(ptr++) - '0';
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode394 le = new LeetCode394();
        System.out.println(le.decodeString("3[a]2[bc]"));
    }
}
