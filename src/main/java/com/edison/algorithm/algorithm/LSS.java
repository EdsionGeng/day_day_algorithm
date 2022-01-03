package com.edison.algorithm.algorithm;

/**
 * 描述:
 * 最长公共子串
 *
 * @author gengyc
 * @create 2021-12-06 15:11
 */
public class LSS {

    public static int longSubStr(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        int[][] dp = new int[ch1.length+1][ch2.length+1];
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                if (ch1[i] == ch2[j ]) {
                    dp[i+1][j+1] = dp[i ][j] + 1;
                } else {
                    dp[i+1][j+1] = 0;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println(result.toString());
        return dp[ch1.length][ch2.length ];

    }

    public static void main(String[] args) {
        String str1 = "abceef";
        String str2 = "a2b2cee3f";
        System.out.println(longSubStr(str1, str2));

    }
}