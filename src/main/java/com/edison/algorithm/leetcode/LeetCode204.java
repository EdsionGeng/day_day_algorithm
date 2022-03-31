package com.edison.algorithm.leetcode;

import java.util.Arrays;

/**
 * 描述:
 * 计数质数
 *
 * @author gengyc
 * @create 2022-03-01 17:22
 */
public class LeetCode204 {

    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = -2;
        for (boolean bool : isPrime) {
            if (bool) ++count;
        }
        return count;
    }

}