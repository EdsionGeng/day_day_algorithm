package com.edison.algorithm.offer;


//二进制中1的个数
public class Offer15 {

    public int hamingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer15 offer15=new Offer15();
        System.out.println(offer15.hamingWeight(11));
    }
}
