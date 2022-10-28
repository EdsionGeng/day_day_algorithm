package com.edison.algorithm.offer;


//把字符串转换成整数
public class Offer67 {

    public int strToInt(String str) {

        if (str == null || str.length() == 0) return 0;

        int sign = 1;
        int start = 0;
        String s = str.trim();
        char c = s.trim().charAt(0);
        if (c == '+') {
            start++;
        } else if (c == '-') {
            sign = -1;
            start++;
        }
        long res = 0;
        for (int i = start; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return (int) res * sign;
            }
            res = res * 10 + s.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && res*sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        }
        return (int) res*sign;

    }

    public static void main(String[] args) {
        Offer67 offer67 = new Offer67();
        System.out.println(offer67.strToInt("-91283472332"));
    }
}
