package com.edison.algorithm.leetcode;

/**
 * 描述:
 * N皇后2
 *
 * @author gengyc
 * @create 2022-01-13 10:24
 */
public class LeetCode52 {

    /**
     * 记录某列是否已有皇后摆放
     */
    private boolean col[];

    /**
     * 记录某条正对角线（左上右下）是否已有皇后摆放（某条对角线对应的摆放位置为 x - y + n - 1）
     */
    private boolean dia1[];

    /**
     * 记录某条斜对角线（左下右上）是否已有皇后摆放（某条对角线对应的摆放位置为 x + y）
     */
    private boolean dia2[];

    public int totalNQueens(int n) {
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        return putQueen(n, 0);
    }

    private int putQueen(int n, int index) {
        int res = 0;
        if (index == n) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && dia1[i - index + n - 1] && !dia2[i + index]) {
                col[i] = true;
                dia1[i - index + n - 1] = true;
                dia2[i + index] = true;
                res += putQueen(n, index + 1);
                col[i] = false;
                dia1[i - index + n - 1] = false;
                dia2[i + index] = false;
            }
        }
        return res;
    }
}