package com.edison.algorithm.offer;

//圆圈中最后剩下的数字
public class Offer62 {

    public int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; i++) {
            f = (m + f) % i;
        }
        return f;
    }

    public static void main(String[] args) {

    }
}
