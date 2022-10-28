package com.edison.algorithm.dp;

public class 区间加法 {

    public static int[] getModifiedArray(int length, int[][] updates) {

        int[] num = new int[length];

        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0], end = updates[i][1], value = updates[i][2];
            for (int j = start; j <= end; j++) {
                num[j] += value;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        int[] num = getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}});
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + "->");
        }
    }
}
