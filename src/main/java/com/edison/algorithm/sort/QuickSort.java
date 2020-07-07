package com.edison.algorithm.sort;

/**
 * @Description 快速排序
 * @Date 2020/3/3下午4:05
 * @Created by edsiongeng
 */
public class QuickSort {

    //数组array中下标为i和j位置的元素进行交换
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void sort(int[] array) {
        reQuickSort(array, 0, array.length - 1);

    }

    private static void reQuickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int partion = partion(array, left, right);
        System.out.println("index:::"+partion);
        reQuickSort(array, left, partion - 1);
        reQuickSort(array, partion + 1, right);

    }


    private static int partion(int[] array, int left, int right) {
        int i = left, j = right + 1;
        int pivot = array[left];
        while (true) {
            while (i < right && array[++i] < pivot) {

            }
            while (j > 0 && array[--j] > pivot) {

            }
            if (i >= j) {
                break;
            } else {
                swap(array, i, j);
            }
        }
        swap(array, left, j);
        return j;
    }


    //测试
    public static void main(String[] args) {
        //int[] array = {7,3,5,2,9,8,6,1,4,7};
        int[] array = {9,  8, 7, 6, 5, 4,10, 3, 2, 1};
        sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
        //打印结果为：1 2 3 4 5 6 7 7 8 9
    }


}
