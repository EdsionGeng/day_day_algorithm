package com.edison.algorithm.math;

public class 颠倒二进制位 {


    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= n & 1;
            n >>= 1;
        }
        Integer.bitCount(1);
        return res;
    }
}
