package com.edison.algorithm.backtrack;

/**
 * 描述:
 * 八皇后问题
 *
 * @author gengyc
 * @create 2021-07-23 16:55
 */
public class BaHuangHou {
    private static int QUEEN_NUM = 8;
    private static int[][] checkboard = new int[QUEEN_NUM][QUEEN_NUM];
    private static int count = 0;

    public static void show() {
        System.out.println("第" + (++count) + "次摆法");
        for (int i = 0; i < QUEEN_NUM; i++) {
            for (int j = 0; j < QUEEN_NUM; j++) {
                System.out.print(checkboard[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static final boolean check(int row, int col) {
        //判断当前上面有木有
        for (int i = row - 1; i >= 0; i--) {
            if (checkboard[i][col] == 1) {
                return false;
            }
        }
        //判断左上方有木有
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (checkboard[i][j] == 1) {
                return false;
            }
        }
        //判断右上方有木有
        for (int i = row - 1, j = col + 1; i >= 0 && j < QUEEN_NUM; i--, j++) {
            if (checkboard[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void play(int row) {
        for (int i = 0; i < QUEEN_NUM; i++) {
            if (check(row, i)) {
                checkboard[row][i] = 1;
                if (row == QUEEN_NUM - 1) {
                    show();
                } else {
                    play(row + 1);
                }
                checkboard[row][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        play(0);
    }

}