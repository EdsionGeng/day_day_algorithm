package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 爬楼梯
 *
 * @author gengyc
 * @create 2022-01-17 11:23
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int res = 0;
            int k = 3;
            int i = 1, j = 2;
            while (k <= n) {
                res = (i + j) % 1000000007;
                i = j;
                j = res;
                k++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        LeetCode70 le = new LeetCode70();
        System.out.println(le.climbStairs(4));
    }

}