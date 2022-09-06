package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 数字1的个数
 *
 * @author gengyc
 * @create 2022-03-16 17:17
 */
public class LeetCode233 {


    public int countDigitOne(int n) {
        if (n < 1) return 0;
        int len = getLenOfNum(n);
        if (len == 1) {
            return 1;
        }
        int tmp = (int) Math.pow(10, len - 1);
        int first = n / tmp; // 获取n的最高位数字
        int firstOneNum = first == 1 ? n % tmp + 1 : tmp; // 获取n的最高位为1时有多少个数字
        int otherOneNum = first * (len - 1) * (tmp / 10); // 在介于n % tmp到n之间的数字中，除了最高位为1，其余各个数字分别为1 的总数和
        return firstOneNum + otherOneNum + countDigitOne(n % tmp);
    }

    private int getLenOfNum(int n) {
        int len = 0;
        while (n != 0) {
            len++;
            n /= 10;
        }
        return len;
    }

    public static void main(String[] args) {
        LeetCode233 le = new LeetCode233();
        System.out.println(le.countDigitOne(100));
    }

}