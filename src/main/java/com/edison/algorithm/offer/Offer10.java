package com.edison.algorithm.offer;

public class Offer10 {

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return (int) ((Math.pow((Math.sqrt(5) + 1) / 2, n) + Math.pow((Math.sqrt(5) - 1) / 2, n)) / Math.sqrt(5));
    }

    public static void main(String[] args) {
        Offer10 le = new Offer10();
        System.out.println(le.fib(5));
    }

}
