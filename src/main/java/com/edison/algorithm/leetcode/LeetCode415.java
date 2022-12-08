package com.edison.algorithm.leetcode;

//字符串相加
public class LeetCode415 {

    public String addStrings(String num1, String num2) {
        int mod = 0;
        int l1 = num1.length() - 1, l2 = num2.length() - 1;
        StringBuffer sb = new StringBuffer();

        while (l1 >= 0 || l2 >= 0 || mod != 0) {
            int n1 = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int n2 = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
            int res = n1 + n2 + mod;
            sb.append(res % 10);
            mod = res / 10;
            l1--;
            l2--;
        }

        return sb.reverse().toString();
    }
}
