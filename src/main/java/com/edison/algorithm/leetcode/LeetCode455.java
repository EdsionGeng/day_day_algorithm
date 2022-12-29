package com.edison.algorithm.leetcode;

import java.util.Arrays;

//分发饼干
public class LeetCode455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childNum = g.length, cookiesNum = s.length;
        int count = 0;
        int childIndex = 0, cookieIndex = 0;

        while (childIndex < childNum && cookieIndex < cookiesNum) {
            if (g[childIndex] <= s[cookieIndex]) {
                childIndex++;
                count++;
            }
            cookieIndex++;
        }


        return count;

    }
}
