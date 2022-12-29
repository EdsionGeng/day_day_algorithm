package com.edison.algorithm.leetcode;

//二维区域和检索-可变
public class LeetCode308 {


    class NumMatrix {
        int[][] data = new int[127][127];
        int[][] matrix;
        private int rowCount;
        private int colCount;


        NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            rowCount = matrix.length;
            colCount = matrix[0].length;
            data = new int[rowCount][colCount];

            for (int i = 0; i < rowCount; i++) {
                for (int j = 1; j < colCount; j++) {
                    data[i][j] = data[i][j - 1] + matrix[i][j];
                }
            }
        }

        public void update(int row, int col, int val) {
            matrix[row][col] = val;
            int fromCol = col;
            if (col == 0) {
                data[row][col] = matrix[row][col];
                fromCol = col + 1;
            }
            for (int i = fromCol; i < colCount; i++) {
                data[row][i] = data[row][i - 1] + matrix[row][i];
            }
        }


        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                sum += data[i][col2 + 1] - data[i][col1];

            }
            return sum;
        }
    }
}
