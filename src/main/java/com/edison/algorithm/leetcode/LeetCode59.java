package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 螺旋矩阵2
 *
 * @author gengyc
 * @create 2022-01-14 14:04
 */
public class LeetCode59 {
    //
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int c = 1, j = 0;
        while (c <= n * n) {
            for (int i = j; i < n - j; i++) {
                arr[j][i] = c++;
            }
            for (int i = j + 1; i < n - j; i++) {
                arr[i][n - j - 1] = c++;
            }
            for (int i = n - j - 2; i >= j; i--) {
                arr[n - j - 1][i] = c++;
            }
            for (int i = n - j - 2; i > j; i--) {
                arr[i][j] = c++;
            }
            j++;
        }
        return arr;
    }

    public static void main(String[] args) {
        LeetCode59 leetCode59 = new LeetCode59();
        int[][] arr = leetCode59.generateMatrix(5);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}