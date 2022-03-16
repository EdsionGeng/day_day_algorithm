package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 矩阵置零
 *
 * @author gengyc
 * @create 2022-01-17 15:59
 */
public class LeetCode73 {

    public void setZeros(int[][] matrix) {
        int[] xNum = new int[matrix[0].length];
        int[] yNum = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    xNum[i] = 1;
                    yNum[i] = 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (xNum[i] == 1 || yNum[i] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

}