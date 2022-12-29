package com.edison.algorithm.leetcode;

//掷骰子N种方法
public class LeetCode1155 {

    //n个筛子 k个面
    public int numRollsToTarget(int n, int k, int target) {
        if (target > n * k || target < n) return 0;
        int mod = (int) 1e9 + 7;
        long[] count = new long[k + 1];
        for (int i = 1; i <= k; i++) {
            count[i] = 1;

        }
        for (int a = 1; a < n; a++) {
            long[] new_count = new long[(a + 1) * k + 1];
            for (int b = a; b <= a*k; b++) {
                for (int c = 1; c <= k; c++) {
                    new_count[b + c] += count[b];
                    new_count[b + c] %= mod;

                }
            }
            count = new_count;
        }
        return (int) count[target];
    }


}
