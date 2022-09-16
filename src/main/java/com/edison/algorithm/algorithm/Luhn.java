package com.edison.algorithm.algorithm;

public class Luhn {
    public static boolean check(int[] digits) {
        int sum = 0;
        int length = digits.length;
        for (int i = 0; i < length; i++) {
            int digit = digits[length - i - 1];
            if (i % 2 == 1) {
                digit *= 2;
            }
            sum += digit > 9 ? digit - 9 : digit;
        }
        return sum % 10 == 0;
    }

    public static void main(String[] args) {
        System.out.println(check(new int[]{3,4,2,6,0,1,1,9,9,2,0,9,1,0,4,6,3,7}));
    }
}
