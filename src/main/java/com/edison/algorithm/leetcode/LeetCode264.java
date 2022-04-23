package com.edison.algorithm.leetcode;

/**
 * @Description 丑数2
 * @Date 2022/4/8下午7:32
 * @Created by edsiongeng
 */
public class LeetCode264 {

    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        int[] result = new int[n];
        result[0] = 1;
        int divisor2 = 0;
        int divisor3 = 0;
        int divisor5 = 0;
        for (int i = 1; i < n; i++) {
            int multiply2 = result[divisor2] * 2;
            int multiply3 = result[divisor3] * 3;
            int multiply5 = result[divisor5] * 5;

            int min = Math.min(multiply2, Math.min(multiply3, multiply5));
            result[i] = min;

            if (multiply2 == min) {
                divisor2++;
            }
            if (multiply3 == min) {
                divisor3++;
            }
            if (multiply5 == min) {
                divisor5++;
            }
        }
        return result[n - 1];

    }

    public static void main(String[] args) {
        LeetCode264 le = new LeetCode264();
        System.out.println(le.nthUglyNumber(10));
    }
}
