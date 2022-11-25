package com.edison.algorithm.leetcode;

/**
 * 描述:
 * X的平方根
 *
 * @author gengyc
 * @create 2022-01-17 11:10
 */
public class LeetCode69 {
    public int mySqrt(int x) {

        long t = x;
        t = 0x5f3759df - (t >> 1);
        while (!(t * t <= x && (t + 1) * (t + 1) > x)) {
            t = (x / t + t) / 2;
        }
        return (int) t;
    }

    public int mySqrt2(int x) {
        if (x == 0) return 0;
        int l = 1, r = x, mid, sqrt;
        while (l <= r) {
            mid = l + (r - l) / 2;
            sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (mid > sqrt) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public int mySqrt3(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int)x;
    }

    public static void main(String[] args) {
        LeetCode69 leetCode69 = new LeetCode69();
        leetCode69.mySqrt2(8);
    }
}