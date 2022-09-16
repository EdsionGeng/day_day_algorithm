package com.edison.algorithm.leetcode;

public class LeetCode509 {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int res = 0, i = 0, j = 1;
        int k = 2;
        while (k <= n) {
            res = i + j;
            i = j;
            j = res;
            k++;
        }
        return res;
    }

    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib2(n - 1) + fib2(n - 2);
    }

    public int fib3(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return (int)(Math.pow(((1 + Math.sqrt(5)) / 2.0), n) / Math.sqrt(5) - Math.pow(((1 - Math.sqrt(5)) / 2.0), n) / Math.sqrt(5));

    }

    public static void main(String[] args) {
        LeetCode509 le = new LeetCode509();
        System.out.println(le.fib2(4));
        System.out.println(le.fib3(4));
        System.out.println(le.fib(4));
    }
}
