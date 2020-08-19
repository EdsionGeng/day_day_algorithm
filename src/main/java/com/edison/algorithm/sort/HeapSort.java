package com.edison.algorithm.sort;

import java.util.Arrays;

/**
 * 描述:
 * 堆排序
 *
 * @author gengyongchang
 * @create 2020-07-29 17:17
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {8, 5, 4, 2, 3, 7, 6, 1, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 第一步，调整为最大堆
     * 第二步：拿每次调整过的堆下标0为最大元素，放在数组末尾，交换
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j >= 0; j--) {
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        //从i的左子节点开始 2*i+1
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //如果左节点小于右节点 k++
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            //如果子节点大于父节点值，将子节点值赋予父节点
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        //将temp放到最终位置
        arr[i] = temp;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {

            adjustHeap(array, i, array.length);
        }
        for (int j = array.length - 1; j >= 0; j--) {
            swap(array, 0, j);
            adjustHeap2(array, 0, j);
        }


    }

    public static void adjustHeap2(int[] array, int i, int length) {
        int temp = array[i];
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && array[k] < array[k + 1]) {
                k++;
            }
            if (array[k] > temp) {
                array[i] = array[k];
                i = k;
            } else {
                break;
            }
        }
        array[i] = temp;
    }
}