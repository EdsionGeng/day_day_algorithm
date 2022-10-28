package com.edison.algorithm.offer;

//不用加减乘除做加法
public class Offer65 {

    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
