package com.edison.algorithm.leetcode;

/**
 * @Description 累加数
 * @Date 2022/4/21下午9:37
 * @Created by edsiongeng
 */
public class LeetCode306 {
    //累加数是一个字符串，组成它的数字可以形成累加序列。
    //
    //一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
    //
    //给定一个只包含数字 ‘0’-‘9’ 的字符串，编写一个算法来判断给定输入是否是累加数。
    //
    //说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
    //
    //示例 1:
    //
    //输入: “112358”
    //输出: true
    //解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
    //示例 2:
    //
    //输入: “199100199”
    //输出: true
    //解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
    //进阶:
    //你如何处理一个溢出的过大的整数输入?
    //————————————————


    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;
        int n = num.length();

        for (int i = 1; i <= (n - 1) / 2; i++) {
            if (i > 1 && num.charAt(0) == '0') break;
            for (int j = i + 1; (n - j) >= i && (n - j) >= j - i; j++) {
                long num1 = Long.parseLong(num.substring(0, i));
                long num2 = Long.parseLong(num.substring(i, j));
                if (isAdditive(num.substring(j), num1, num2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdditive(String remain, long num1, long num2) {
        if (remain.equals("")) return true;
        long sum = num1 + num2;
        String str = String.valueOf(sum);
        if (!remain.startsWith(str)) return false;
        return isAdditive(remain.substring(str.length()), num2, sum);
    }

    public static void main(String[] args) {
        LeetCode306 le = new LeetCode306();
        le.isAdditiveNumber("199100199");
    }

}
