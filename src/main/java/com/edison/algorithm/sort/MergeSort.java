package com.edison.algorithm.sort;

/**
 * @Description 归并排序
 * @Date 2020/3/2下午4:16
 * @Created by edsiongeng
 */
public class MergeSort {

    public static int[] merge(int[] arr, int start, int end) {
        if (end > start) {
            int mid = (end - start) / 2 + start;
            merge(arr, start, mid);
            merge(arr, mid + 1, end);
            mergeSort(arr, start, mid, end);
        }
        return arr;
    }

    public static void mergeSort(int[] data, int start, int mid, int last) {
        int[] temp = new int[last - start + 1];
        int i = start;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j <= last) {
            if (data[i] > data[j]) {
                temp[k++] = data[j++];
            } else {
                temp[k++] = data[i++];
            }
        }
        while (i <= mid && j > last) {
            temp[k++] = data[i++];
        }
        while (i > mid && j <= last) {
            temp[k++] = data[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            data[start + l] = temp[l];
        }

    }



    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,4,3,2,1};
        int[] a=merge(array,0,array.length-1);
        for(int i : a){
            System.out.print(i+" ");
        }
    }
}
