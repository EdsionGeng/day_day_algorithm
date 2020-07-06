package com.edison.algorithm.sort;

/**
 * @Description TODO
 * @Date 2020/7/5下午4:15
 * @Created by edsiongeng
 */
public class MergeSort2 {

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
        int temp[] = new int[end - start + 1];
        int i = start, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

            }
        }
        while (i <= mid && j > end) {
            temp[k++] = arr[i++];
        }
        while (i > mid && j <= end) {
            temp[k++] = arr[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            arr[l + start] = temp[l];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 6, 5, 4, 9, 8};
        int[] result = merge(arr, 0, arr.length - 1);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
