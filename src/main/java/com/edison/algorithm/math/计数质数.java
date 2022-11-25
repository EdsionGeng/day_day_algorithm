package com.edison.algorithm.math;

public class 计数质数 {


    public int countPrimes(int n) {
        int result = 0;
        int[] pre = new int[n];
        for (int i = 2; i < n; i++) {
            if (pre[i] == 0) {
                result++;
                for (int j = 1; j * i < n; j++) {
                    pre[i * j] = 1;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(3 >>> 1);
    }
}
