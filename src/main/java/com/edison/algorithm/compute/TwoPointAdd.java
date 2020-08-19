package com.edison.algorithm.compute;

import java.util.Arrays;

/**
 * @Description 指针相遇
 * @Date 2019/12/4下午11:59
 * @Created by edsiongeng
 */
public class TwoPointAdd {

    public static int[] twopoint(int[] num, int target) {
        int i = 0, j = num.length - 1;
        while (i < j) {
            if (num[i] + num[j] < target) {
                i++;
            } else if (num[i] + num[j] > target) {
                j--;
            } else {
                break;
            }
        }
        return new int[]{i, j};
    }

    public static void main(String[] args) {
//        int[] num = {2, 7, 9, 11};
//        int[] result = twopoint(num, 18);
//        for (int i : result) {
//            System.out.println(i);
//        }
        int[] arr = {0, 8, 7, 6, 5, 4, 3, 2, 1};
//        int[] result = merge(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(result));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] merge(int[] arr, int start, int end) {
        if (end > start) {
            int mid = (end - start) / 2 + start;
            merge(arr, start, mid);
            merge(arr, mid + 1, end);
            mergeSort(arr, start, mid, end);
        }
        return arr;
    }

    public static void mergeSort(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] > arr[j]) {
                temp[k++] = arr[j++];
            } else {
                temp[k++] = arr[i++];
            }
        }
        while (i <= mid && j > end) {
            temp[k++] = arr[i++];
        }
        while (i > mid && j <= end) {
            temp[k++] = arr[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            arr[start + l] = temp[l];
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = getPivot(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);

    }

    public static int getPivot(int[] arr, int left, int right) {
        int i = left, j = right + 1;
        int pivot = arr[left];
        while (true) {
            while (i < right && arr[++i] < pivot) {

            }
            while (j > 0 && arr[--j] > pivot) {

            }
            if (i >= j) {
                break;
            } else {
                swap(arr, i, j);
            }
        }
        swap(arr, left, j);
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
