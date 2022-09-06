package com.edison.algorithm.leetcode;

//给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
//
//示例 1:
//
//输入: 16
//输出: true
//示例 2:
//
//输入: 5
//输出: false
//进阶：
//你能不使用循环或者递归来完成本题吗？
//0xaaaaaaaa = 10101010101010101010101010101010 (偶数位为1，奇数位为0）
//0x55555555 = 1010101010101010101010101010101 (偶数位为0，奇数位为1）
//0x33333333 = 110011001100110011001100110011 (1和0每隔两位交替出现)
//0xcccccccc = 11001100110011001100110011001100(0和1每隔两位交替出现)
//0x0f0f0f0f = 00001111000011110000111100001111 (1和0每隔四位交替出现)
//0xf0f0f0f0 = 11110000111100001111000011110000 (0和1每隔四位交替出现)
//
//(num & 0x55555555) << 1)
//
//((x & 0x55555555) << 1 --- 奇数位移到偶数位
//((x >> 1) & 0x55555555); --- 先右移一位，等于拿到奇数位

public class LeetCode342 {
    public boolean isPowerOfFour(int num) {
        int x = 0x55555555;
        System.out.println((num & (num - 1)) == 0);
        System.out.println((num & x) == num);
        return (num > 0) && ((num & (num - 1)) == 0) & ((num & x) == num);
    }

    public static void main(String[] args) {

        LeetCode342 le = new LeetCode342();
        le.isPowerOfFour(64);
    }
}
