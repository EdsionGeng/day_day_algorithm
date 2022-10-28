package com.edison.algorithm.offer;


//顺时针打印矩阵
public class Offer29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int[] result = new int[matrix.length * matrix[0].length];
        int upBound = 0, leftBound = 0, rightBound = matrix[0].length - 1, downBound = matrix.length - 1;
        int index = 0;
        while (true) {
            for (int i = leftBound; i <= rightBound; i++) {
                result[index++] = matrix[upBound][i];
            }
            if (++upBound > downBound) break;
            for (int i = upBound; i <= downBound; i++) {
                result[index++] = matrix[i][rightBound];
            }
            if (--rightBound < leftBound) break;
            for (int i = rightBound; i >= leftBound; i--) {
                result[index++] = matrix[downBound][i];
            }
            if (--downBound < upBound) break;
            for (int i = downBound; i >= upBound; i--) {
                result[index++] = matrix[i][leftBound];
            }
            if (++leftBound > rightBound) break;
        }
        return result;
    }

    public static void main(String[] args) {
        Offer29 offer29 = new Offer29();
        int[] result = offer29.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
    }
}
