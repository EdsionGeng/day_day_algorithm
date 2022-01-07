package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 接雨水
 *
 * @author gengyc
 * @create 2022-01-07 13:07
 */
public class LeetCode42 {
    public int trap(int[] height) {
        int n = height.length, sum = 0;
        if (n == 0) return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }

    public int trap2(int[] height) {
        int left = 1;
        int right = height.length - 2;
        int leftMax = 0, rightMax = 0;
        int sum = 0;
        while (left <= right) {
            if (height[left - 1] < height[right + 1]) {
                leftMax = Math.max(leftMax, height[left - 1]);
                if (leftMax > height[left]) {
                    sum += leftMax - height[left];
                }
            } else {
                rightMax = Math.max(rightMax, height[right + 1]);
                if (rightMax > height[right]) {
                    sum += rightMax - height[right];
                }
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        LeetCode42 leetCode42 = new LeetCode42();
        leetCode42.trap(height);
    }

}