package com.edison.algorithm.algorithm;

import java.util.Arrays;

/**
 * 描述:
 * 最佳调度问题
 *
 * @author gengyc
 * @create 2021-12-22 9:50
 */
public class BestSchedule {

    public static void main(String[] args) {
        //   int machine = 4;
        int[] time = {3, 4, 1, 2, 5, 3, 7, 6, 9, 10};
        Arrays.sort(time);
        int[] reverse = new int[10];
        for (int i = time.length - 1, j = 0; i >= 0; i--, j++) {
            reverse[j] = time[i];
        }
        int[] total = {0, 0, 0, 0};
        for (int i = 0; i < reverse.length; i++) {
            int minTime = total[0];
            int k = 0;
            for (int j = 0; j < total.length; j++) {
                if (minTime > total[j]) {
                    k = j;
                    minTime = total[j];
                }
            }
            total[k] += reverse[i];
        }
        for (int i = 0; i <total.length ; i++) {
            System.out.println(total[i]);
        }
    }

}