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

    public static void merge(int[] array, int start, int last) {
        if (start<last) {
            int mid = (last - start) / 2 + start;
            merge(array, start, mid);
            merge(array, mid + 1, last);
            mergeSort(array, start, mid, last);
        }
    }

    public static void mergeSort(int[] array, int start, int mid, int last) {
        int i = start, j = mid + 1, k = 0;
        int[] temp = new int[last - start + 1];
        while (i <= mid && j <= last) {
            if (array[i] > array[j]) {
                temp[k++] = array[j++];
            } else {
                temp[k++] = array[i++];
            }
        }
        while (i <= mid && j > last) {
            temp[k++] = array[i++];
        }
        while (i > mid && j <= last) {
            temp[k++] = array[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            array[start + l] = temp[l];
        }

    }

    public static void main(String[] args) {
        int[] array = {4, 2, 8, 6, 5, 7, 9, 1, 3};
        merge(array, 0, array.length - 1);
        display(array);
    }
}
