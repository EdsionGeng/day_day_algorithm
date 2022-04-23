package com.edison.algorithm.leetcode;

/**
 * @Description 整数转换英文表示
 * @Date 2022/4/14下午6:10
 * @Created by edsiongeng
 */
public class LeetCode273 {
    //示例 1:
    //
    //输入: 123
    //输出: “One Hundred Twenty Three”
    //示例 2:
    //
    //输入: 12345
    //输出: “Twelve Thousand Three Hundred Forty Five”
    //示例 3:
    //
    //输入: 1234567
    //输出: “One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven”
    //示例 4:
    //
    //输入: 1234567891
    //输出: “One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One”
    //————————————————
    //版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/a1439775520/article/details/104658345

    final static String[] zeroToNineteen = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};
    final static String[] twentyToNinety = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    final int BILLION = 1000000000;
    final int MILLION = 1000000;
    final int THOUSAND = 1000;
    final int HUNDRED = 100;

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder builder = new StringBuilder();
        if (num >= BILLION) {
            if (builder.length() != 0) builder.append(" ");
            builder.append(numberToWords(num / BILLION)).append(" Billion");
            num %= BILLION;
        }
        if (num >= MILLION) {
            if (builder.length() != 0) builder.append(" ");
            builder.append(numberToWords(num / MILLION)).append(" Million");
            num %= MILLION;
        }
        if (num >= THOUSAND) {
            if (builder.length() != 0) builder.append(" ");
            builder.append(numberToWords(num / THOUSAND)).append(" Thousand");
            num %= THOUSAND;
        }
        if (num >= HUNDRED) {
            if (builder.length() != 0) builder.append(" ");
            builder.append(numberToWords(num / HUNDRED)).append(" Hundred");
            num %= HUNDRED;
        }
        if (num < 20 && num != 0) {
            if (builder.length() != 0) builder.append(" ");
            builder.append(zeroToNineteen[num]);
        } else {
            if (builder.length() != 0) builder.append(" ");
            builder.append(twentyToNinety[num / 10 - 2]);
            if (num % 10 != 0) {
                if (builder.length() != 0) builder.append(" ");
                builder.append(zeroToNineteen[num % 10]);
            }

        }
        return builder.toString();
    }
}
