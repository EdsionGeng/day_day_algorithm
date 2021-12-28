package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 盛水最多容器
 *
 * @author gengyc
 * @create 2021-12-28 10:46
 */
public class LeetCode11 {
    public static int maxArea(int[] height) {
        int max = 0;
        int a = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 1; j < height.length; j++) {
                a = Math.min(height[i], height[j]);
                max = Math.max((j - i) * a, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(a));
    }

}