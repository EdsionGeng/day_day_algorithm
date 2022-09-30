package com.edison.algorithm.offer;

//1-n整数1出现的次数
public class Offer43 {

    public int countDigitOne(int n) {
        if (n < 1) return 0;
        int len = getNumLen(n);
        if (len == 1) {
            return 1;
        }
        int temp = (int) Math.pow(10, len - 1);
        int first = n / temp;
        int firstNum = first == 1 ? n % temp + 1 : temp;
        int otherNum = first * (len - 1) * (temp / 10);
        return firstNum + otherNum + countDigitOne(n % temp);
    }

    private int getNumLen(int n) {
        int len = 0;
        while (n != 0) {
            len++;
            n /= 10;
        }
        return len;
    }

    public static void main(String[] args) {
        Offer43 offer43 = new Offer43();
        offer43.countDigitOne(21);
    }
}
