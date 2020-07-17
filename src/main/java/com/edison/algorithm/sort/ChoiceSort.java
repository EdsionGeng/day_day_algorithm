package com.edison.algorithm.sort;

/**
 * @Description 选择排序
 * @Date 2020/2/28下午11:21
 * @Created by edsiongeng
 */
public class ChoiceSort {

    public static int[] sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i; j < array.length; j++) {
                if (array[min] >array[j]) {
                    min = j;
                }

            }
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }

        }
        display(array);
        return array;
    }

    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 8, 5, 7, 6, 9, 3, 1};
        sort(array);
    }
}
