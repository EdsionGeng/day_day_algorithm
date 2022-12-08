package com.edison.algorithm.leetcode;

//求任意n位对应数字
public class LeetCode400 {

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

    public static void main(String[] args) {
        LeetCode400 le = new LeetCode400();
        le.findNthDigit(111);
    }
}
