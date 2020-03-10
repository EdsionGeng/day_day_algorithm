package com.edison.algorithm.algorithm;

import java.awt.event.KeyAdapter;

/**
 * @Description 背包问题
 * @Date 2020/3/2下午5:34
 * @Created by edsiongeng
 */
public class Knapsack {
    private int[] weights;//可供选择重量
    private boolean[] selects;//记录是否被选择

    public Knapsack(int[] weights) {
        this.weights = weights;
        selects = new boolean[weights.length];
    }

    /**
     * 找出符合承重重量组合
     *
     * @param total 总重量
     * @param index 可供选择的重量下标
     */
    public void knapsack(int total, int index) {
        if (total < 0 || total > 0 && index >= weights.length) {
            return;
        }
        if (total == 0) {
            for (int i = 0; i < index; i++) {
                if (selects[i] == true) {
                    System.out.print(weights[i] + " ");
                }
            }
            System.out.println();
            return;
        }


        selects[index] = true;
        knapsack(total - weights[index], index + 1);
        selects[index] = false;
        knapsack(total, index + 1);

    }



    public static void main(String[] args) {
        int[] array = {11, 9, 7, 6, 5};
        int total = 21;
        Knapsack k = new Knapsack(array);
        k.knapsack(total,0);
    }
}
