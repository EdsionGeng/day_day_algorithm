package com.edison.algorithm.math;

public class 阶乘后的零 {

    public int trailingZeroes(int n) {
        if (n < 5) return 0;
        return n / 5 + trailingZeroes(n / 5);
    }
}
