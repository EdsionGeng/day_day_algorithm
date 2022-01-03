package com.edison.algorithm.leetcode;

/**
 * 描述:
 * Z字形变换
 *
 * @author gengyc
 * @create 2021-12-29 11:05
 */
public class LeetCode6 {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int[] rowIndex = new int[numRows];
        char[] chars = new char[s.length()];
        int n = 0;
        int burketSize = numRows * 2 - 2;
        int burketNum = chars.length / burketSize;
        int rem = chars.length % burketSize;
        for (int i = 1; i < numRows; i++) {
            int flag = i == 1 ? 1 : 2;
            n = flag * burketNum + (rem >= i ? (1 + (burketSize - rem + 1 < i ? 1 : 0)) : 0);
            rowIndex[i] = rowIndex[i - 1] + n;
        }
        int flag = -1;
        int curRow = 0;
        for (char c : s.toCharArray()) {
            chars[rowIndex[curRow]] = c;
            rowIndex[curRow] = rowIndex[curRow] + 1;
            if (curRow == 0 || curRow == numRows - 1) {
                flag = -flag;
            }
            curRow += flag;
        }
        return new String(chars);
    }

    public static String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length());
        int a, j;
        for (int i = 0; i < numRows; i++) {
            a = 0;
            j = i;
            while (true) {
                if (j < s.length()) {
                    sb.append(s.charAt(j));
                } else {
                    break;
                }
                System.out.println(a ^ 1);
                if ((a ^= 1) == 1) {
                    j += 2 * ((numRows - i - 1) == 0 ? i : numRows - i - 1);
                } else {
                    j += 2 * (i == 0 ? numRows - i - 1 : i);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert2("LEETCODEISHIRING", 4));
        /**
         * L     D     R
         * E   O E   I I
         * E C   I H   N
         * T     S     G
         */
    }
}