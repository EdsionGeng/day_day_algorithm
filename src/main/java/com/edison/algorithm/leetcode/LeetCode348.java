package com.edison.algorithm.leetcode;

//设计井字棋
public class LeetCode348 {


    class TicTacToe {

        private int n;

        private int[] rows;

        private int[] cols;

        private int dia1, dia2;


        TicTacToe(int n) {
            this.n = n;
            rows = new int[n];
            cols = new int[n];
            dia1 = 0;
            dia2 = 0;
        }

        int move(int row, int col, int player) {

            int cell = 1 == player ? 1 : -1;
            int sum = 1 == player ? n : -n;
            rows[row] += cell;
            if (sum == rows[row]) return player;
            cols[col] += cell;
            if (sum == cols[col]) return player;

            if (row == col) {
                dia1 += cell;
                if (sum == dia1) return player;
            }

            if (row + col == n - 1) {
                dia2 += cell;
                if (sum == dia2) return player;
            }
            return 0;
        }

    }

}
