package com.edison.algorithm.leetcode;

//二进制翻转变种题
public class LeetCode476 {

    public int findComplement(int num) {
        int temp = num;
        int i = 0;
        while (temp > 0) {
            i++;
            temp >>= 1;
        }
        return num ^ ((1 << i) - 1);

    }

    public static void main(String[] args) {
        LeetCode476 le = new LeetCode476();
        int result=le.findComplement(5);
    }
}
