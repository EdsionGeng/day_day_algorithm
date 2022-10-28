package com.edison.algorithm.dp;

public class 比特位计数 {
    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
            res[i] = Integer.bitCount(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = countBits(5);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
