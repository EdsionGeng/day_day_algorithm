package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 快乐数
 *
 * @author gengyc
 * @create 2022-03-01 17:04
 */
public class LeetCode202 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = squaresum(slow);
            fast = squaresum(fast);
            fast = squaresum(fast);
        } while (slow != fast);
        if(fast==1){
            return true;
        }
        return false;
    }


    private int squaresum(int m) {
        int square = 0;
        while (m != 0) {
            square += (m % 10) * (m % 10);
            m = m / 10;
        }
        return square;
    }

}