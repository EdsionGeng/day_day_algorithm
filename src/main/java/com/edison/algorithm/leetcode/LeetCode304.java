package com.edison.algorithm.leetcode;

/**
 * @Description TODO
 * @Date 2022/4/21下午9:19
 * @Created by edsiongeng
 */
public class LeetCode304 {
    //Range Sum Query 2D
    //上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。
    //
    //示例:
    //
    //给定 matrix = [
    //[3, 0, 1, 4, 2],
    //[5, 6, 3, 2, 1],
    //[1, 2, 0, 1, 5],
    //[4, 1, 0, 1, 7],
    //[1, 0, 3, 0, 5]
    //]
    //
    //sumRegion(2, 1, 4, 3) -> 8
    //sumRegion(1, 1, 2, 2) -> 11
    //sumRegion(1, 2, 2, 4) -> 12
    //说明:
    //
    //你可以假设矩阵不可变。
    //会多次调用 sumRegion 方法。
    //你可以假设 row1 ≤ row2 且 col1 ≤ col2。
    //————————————————
    //版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/a1439775520/article/details/104681875

    static class NumMatrix {
        int[][] data = new int[127][127];

        public NumMatrix(int[][] matrix) {
            if (matrix.length > 0) {
                for (int i = 0; i < matrix.length; i++) {
                    int sum = 0;
                    for (int j = 1; j <= matrix[0].length; j++) {
                        sum += matrix[i][j - 1];
                        data[i][j] = sum;
                    }
                }
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

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
    }
}
