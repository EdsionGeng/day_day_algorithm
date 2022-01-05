package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 实现两数相除
 *
 * @author gengyc
 * @create 2022-01-04 16:02
 */
public class LeetCode29 {
    /**
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     * <p>
     * 返回被除数 dividend 除以除数 divisor 得到的商。
     * <p>
     * 示例 1:
     * <p>
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 说明:
     * <p>
     * 被除数和除数均为 32 位有符号整数。
     * 除数不为 0。
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
     */

    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        double dividendDou = (double) dividend;
        double divisorDou = (double) divisor;
        double logAnswer = Math.log(Math.abs(dividendDou)) - Math.log(Math.abs(divisorDou));
        double answer = Math.exp(logAnswer);
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            answer = -answer;
        }
        return (int) answer;
    }

    public int divide2(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        System.out.println(dividend ^ divisor);
        negative = (dividend ^ divisor) < 0;
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((t >> i) >= d) {
                result += 1 << i;
                t -= d << i;
            }
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        LeetCode29 leetCode29 = new LeetCode29();
        leetCode29.divide2(33,-4);
    }
}