package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 跳跃游戏2
 *
 * @author gengyc
 * @create 2022-01-13 13:26
 */
public class LeetCode55 {
    public static boolean canJump(int[] nums) {
        int n = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > n) {
                n = 1;
            } else {
                n++;
            }
            if (i == 0 && n > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] num = {2, 3, 1, 1, 4};
        canJump(num);
    }

}