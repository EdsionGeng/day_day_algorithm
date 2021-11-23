package com.edison.algorithm.string;

/**
 * 描述:
 * 暴力匹配
 *
 * @author gengyc
 * @create 2021-11-17 16:37
 */
public class BFMatch {
    public int match(String content, String value) {
        if (content.length() == 0 || value.length() == 0) {
            return 0;
        }
        int i = 0, j = 0;
        while (i < content.length() && j < value.length()) {
            if (content.charAt(i) == value.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j >= value.length()) {
            return i - j + 1;
        } else {
            return 0;
        }
    }

}