package com.edison.algorithm.sort;

/**
 * @Description 插入排序
 * @Date 2020/2/28下午11:45
 * @Created by edsiongeng
 */
public class InsertSort {
    public static int[] sort(int[] array) {
        int j;
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            j = i;
            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;

        }
        return array;
    }

    //遍历显示数组
    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 8, 6, 5, 7, 9, 1, 3};
        array = sort(array);
        display(array);
    }
}
