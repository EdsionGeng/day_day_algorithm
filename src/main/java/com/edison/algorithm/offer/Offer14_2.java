package com.edison.algorithm.offer;

public class Offer14_2 {
    public static int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;

        }
        long res = 1L;
        int p = (int) 1e9 + 7;
        while (n > 4) {
            res = res * 3 % p;
            n -= 3;
        }
        return (int) (res * n % p);
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(120));
    }
}
