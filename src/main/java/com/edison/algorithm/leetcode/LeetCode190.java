package com.edison.algorithm.leetcode;

//给定十进制整数，输出二进制翻转结果
public class LeetCode190 {

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans += n & 1;
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode190 le = new LeetCode190();
        System.out.println(le.reverseBits(43261596));
        System.out.println(5&1);
        System.out.println(5&0);
        System.out.println(6&-6);
    }
}
