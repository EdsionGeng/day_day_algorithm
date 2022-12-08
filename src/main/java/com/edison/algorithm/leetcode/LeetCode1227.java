package com.edison.algorithm.leetcode;

//飞机座位分配概率
public class LeetCode1227 {

    public double nthPersonGetNthSeat(int n) {
        if (n <= 2) return 1.0 / n;
        double prob = 0.5;
        for (int i = 3; i <= n; i++) {
            prob = (1.0 + (i - 2) * prob) / i;
        }
        return prob;
    }
}
