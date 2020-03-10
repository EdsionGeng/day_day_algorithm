package com.edison.algorithm.sort;

/**
 * @Description 冒泡排序
 * @Date 2020/2/27下午4:59
 * @Created by edsiongeng
 */
public class BubbleSort {

    public static int[] sort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            boolean flag = true;

            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            System.out.println(i + " sort result:");
            display(array);

        }
        return array;
    }

    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 8, 9, 5, 7, 6, 1, 3};
        sort(array);
    }

}
