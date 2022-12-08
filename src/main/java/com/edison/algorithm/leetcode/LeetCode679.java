package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

//24点游戏
public class LeetCode679 {

    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;


    public boolean judgePoint24(int[] cards) {

        return solve(new double[]{cards[0], cards[1], cards[2], cards[3]});
    }

    public boolean solve(double[] list) {
        if (list.length == 1) return Math.abs(list[0] - TARGET) < EPSILON;
        for (int i = 0; i < list.length; i++) {
            for (int j = 1; j < list.length; j++) {
                double[] next = new double[list.length - 1];
                for (int k = 0, pos = 0; k < list.length; k++) {
                    if (k != i && k != j) {
                        next[pos++] = list[k];
                    }
                }
                for (double num : calculate(list[i], list[j])) {
                    next[next.length - 1] = num;
                    if (solve(next)) return true;
                }
            }
        }
        return false;
    }

    public List<Double> calculate(double a, double b) {
        List<Double> list = new ArrayList<>();
        list.add(a + b);
        list.add(a - b);
        list.add(b - a);
        list.add(a * b);

        if (!(Math.abs(b) < EPSILON)) list.add(a / b);
        if (!(Math.abs(a) < EPSILON)) list.add(b / a);
        return list;
    }

    public static void main(String[] args) {
        LeetCode679 le = new LeetCode679();
        System.out.println(le.judgePoint24(new int[]{4, 1, 8, 7}));
    }
}
