package com.edison.algorithm.dp;

public class 区域检索 {

    //数组不可变

    //矩阵不可变
   static class NumArray {
        int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];
            sum[0] = nums[0];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];

            }
        }

        int[][] dp;

        public NumArray(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
            dp = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] + matrix[i][j] - dp[i][j];
                }
            }
        }

        public int sumRange(int left, int right) {

            return sum[right + 1] - sum[left];

        }

        //矩阵不可变
        public int matrixRange(int row1, int col1, int row2, int col2) {

            return dp[row2 + 1][col2 + 1] + dp[row1][col1] - dp[row1][col2 + 1] - dp[row2 + 1][col1];

        }
    }

    public static void main(String[] args) {
        NumArray numArray=new NumArray(new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
        System.out.println(numArray.matrixRange(2,1,4,3));
    }


}
