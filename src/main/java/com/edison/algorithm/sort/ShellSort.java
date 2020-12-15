package com.edison.algorithm.sort;

import java.util.Arrays;

/**
 * @Description 希尔排序
 * @Date 2020/3/3下午2:52
 * @Created by edsiongeng
 */
public class ShellSort {

    public static void shellKnuthSort(char[] array) {
        System.out.println("原数组为：" + Arrays.toString(array));
        int step = 1;
        while (step < array.length / 3) {
            step = step * 3 + 1;
        }

        while (step > 0) {
            for (int i = step; i < array.length; i++) {
                char temp = array[i];
                int j = i;
                while (j > step - 1 && temp < array[j - step]) {
                    array[j] = array[j - step];
                    j -= step;
                }
                array[j] = temp;
                System.out.println("sort" + i + " 数组为：" + Arrays.toString(array));
            }
            step = (step - 1) / 3;
        }
        System.out.println("final sort result:" + Arrays.toString(array));

    }

    public static void shellSort(int[] array) {
        System.out.println("original array:" + Arrays.toString(array));
        int step;
        int len = array.length;
        for (step = len / 2; step > 0; step /= 2) {
            for (int i = step; i < array.length; i++) {
                int j = i;
                int temp = array[j];
                if (array[j] < array[j - step]) {
                    while (j - step >= 0 && temp < array[j - step]) {
                        array[j] = array[j - step];
                        j -= step;
                    }
                    array[j] = temp;
                }
            }
            System.out.println("间隔为" + step + " sort result:" + Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 8, 9, 5, 7, 6, 1, 3, 10};
       // shellKnuthSort(array);

        char[] chars = {'E', 'A', 'S', 'Y', 'S', 'H', 'E', 'L', 'L', 'S','O','R','T','Q','U','E','S','T','I','O','N'};
        shellKnuthSort(chars);
    }
    }
