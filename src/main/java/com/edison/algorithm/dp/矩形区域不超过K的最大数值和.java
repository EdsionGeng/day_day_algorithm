package com.edison.algorithm.dp;

public class 矩形区域不超过K的最大数值和 {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] nums = new int[cols];
        int max = Integer.MIN_VALUE;
        int sum;
        for (int up = 0; up < rows; up++) {
            for (int j = 0; j < cols; j++) {
                nums[j] = 0;
            }
            for (int down = up; down < rows; down++) {
                for (int j = 0; j < cols; j++) {
                    nums[j] += matrix[down][j];
                }
                for (int left = 0; left < cols; left++) {
                    sum = 0;
                    for (int right = left; right < cols; right++) {
                        sum += nums[right];
                        if (sum <= k && sum > max) {
                            max = sum;
                        }
                    }
                }
            }
        }
        return max;
    }
}
