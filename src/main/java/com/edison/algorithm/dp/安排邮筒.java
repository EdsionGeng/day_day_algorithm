package com.edison.algorithm.dp;

import java.util.Arrays;

//houses=[2,3,5,12,18],k=2
public class 安排邮筒 {

    public static int minDistance(int[] houses, int k) {
        int n = houses.length;
        Arrays.sort(houses);
        int[][] medsum = new int[n][n];
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                medsum[i][j] = medsum[i + 1][j - 1] + houses[j] - houses[i];
            }
        }
        int[][] f = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            f[i][1] = medsum[0][i];
            for (int j = 2; j <= k && j <= i + 1; j++) {
                for (int l = 0; l < i; l++) {
                    f[i][j] = Math.min(f[i][j], f[l][j - 1] + medsum[l + 1][i]);
                }
            }
        }
        return f[n - 1][k];
    }


    public static void main(String[] args) {
        System.out.println(minDistance(new int[]{2, 3, 5, 12, 18}, 2));
    }
}
