package com.edison.algorithm.math;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class 分数到小数 {

    public static String fractionToDecimal(int numerator, int denominator) {
        long x = numerator, y = denominator;
        if (x % y == 0) return "" + x + y;
        String res = "";
        if ((x < 0) ^ (y < 0)) res += '-';
        x = Math.abs(x);
        y = Math.abs(y);
        res+=(String.valueOf(x / y) + '.');
        x %= y;
        Map<Long, Integer> hashMap = new HashMap<>();

        while (x != 0) {
            hashMap.put(x, res.length());
            x *= 10;
            res += x / y;
            x %= y;
            if (hashMap.containsKey(x)) {
                res = res.substring(0, hashMap.get(x)) + "(" + res.substring(hashMap.get(x)) + ")";
                break;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(2, 3));
    }
}
