package com.edison.algorithm.offer;

//数字序列中某一位数字
public class Offer44 {

    public int findNthDigit(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }

    public int findNthDigit2(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;


        return Long.toString(num).charAt((n - 1) % digit)-'0';

    }

    public static void main(String[] args) {
        Offer44 le = new Offer44();
        int res = le.findNthDigit2(19);
        System.out.println(res);
    }
}
