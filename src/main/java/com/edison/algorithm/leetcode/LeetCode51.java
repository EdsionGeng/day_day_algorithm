package com.edison.algorithm.leetcode;

/**
 * 描述:
 * N皇后
 *
 * @author gengyc
 * @create 2022-01-13 9:30
 */
public class LeetCode51 {
    static int NUM = 8;
    public static int[][] board = new int[NUM][NUM];
    static int i=0;
    public static void show() {
        System.out.println("第"+(++i)+"种摆法");
        for (int i = 0; i < NUM; i++) {
            for (int j = 0; j < NUM; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("end-----------");
    }

    public static boolean check(int row, int col) {
        //判断正上方
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < NUM; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void play(int row) {
        for (int i = 0; i < NUM; i++) {
            if (check(row, i)) {
                board[row][i] = 1;
                if (row == NUM - 1) {
                    show();
                } else {
                    play(row + 1);
                }
                board[row][i] = 0;
            }
        }

    }

    public static void main(String[] args) {
        play(0);
    }

}