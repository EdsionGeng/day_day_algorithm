package com.edison.algorithm.leetcode;

//用 Rand7 实现Rand10
public class LeetCode470 {


    public int rand10() {
        int row, col, idx;
        do {
            row = rand10();
            col = rand10();
            idx = col + (row - 1) * 7;

        } while (idx > 40);


        return 1 + (idx - 1) % 10;
    }
}
