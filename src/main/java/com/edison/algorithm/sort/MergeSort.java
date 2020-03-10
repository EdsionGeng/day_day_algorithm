package com.edison.algorithm.sort;

/**
 * @Description 归并排序
 * @Date 2020/3/2下午4:16
 * @Created by edsiongeng
 */
public class MergeSort {


    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int aNum = 0, bNum = 0, cNum = 0;

        while (aNum < a.length && bNum < b.length) {
            if (a[aNum] >= b[bNum]) {
                c[cNum++] = b[bNum++];
            } else {
                c[cNum++] = a[aNum++];
            }

        }
        while (aNum == a.length && bNum < b.length) {
            c[cNum++] = b[bNum++];
        }

        while (bNum == b.length && aNum < a.length) {
            c[cNum++] = a[aNum++];
        }
        return c;

    }


    public static int[] mergeSort(int[] c, int start, int last) {
        if (last > start) {
            int mid = start + (last - start) / 2;
            mergeSort(c, start, mid);
            mergeSort(c, mid + 1, last);
            merge(c,start,mid,last);

        }
        return c;
    }


    public static void merge(int[] c, int start, int mid, int last) {
        int[] temp = new int[last - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= last) {
            if (c[i] < c[j]) {
                temp[k++] = c[i++];
            } else {
                temp[k++] = c[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = c[i++];
        }
        while (j <= last) {
            temp[k++] = c[j++];
        }

        for (int l = 0; l < temp.length; l++) {
            c[l + start] = temp[l];

        }
    }
}
