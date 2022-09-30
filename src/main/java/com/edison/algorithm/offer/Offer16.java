package com.edison.algorithm.offer;

//x的次方
public class Offer16 {
    public double myPow(double x, int n) {
        long b = n;
        return b>=0?culc(x, b):1.0/culc(x,-b);
    }

    public double culc(double base, long power) {
        if (power == 0) return 1.0;
        double t = culc(base, power >> 1);
        if ((power & 1) == 1) return t * t * base;
        return t * t;
    }

    public static void main(String[] args) {
        Offer16 offer = new Offer16();
        // System.out.println(offer.myPow(2,3));
        System.out.println(offer.myPow(2.1, 3));
    }
}
