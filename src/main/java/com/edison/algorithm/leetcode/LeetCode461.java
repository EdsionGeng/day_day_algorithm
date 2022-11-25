package com.edison.algorithm.leetcode;

//计算汉明距离
public class LeetCode461 {

    public int hammingDistance(int x, int y) {
        int diff = x ^ y, ans = 0;
        while (diff!=0) {
            ans += diff & 1;
            diff >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode461 le = new LeetCode461();
        System.out.println(le.hammingDistance(2, 8));
        System.out.println(8>>1);
    }
}
