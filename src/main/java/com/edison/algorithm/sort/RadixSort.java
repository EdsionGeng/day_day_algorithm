package com.edison.algorithm.sort;

import java.util.Arrays;

/**
 * @Description 基数排序
 * @Date 2020/3/10上午8:54
 * @Created by edsiongeng
 */
public class RadixSort {


    public static void radinSort(int[] arr) {
        if (arr.length <= 1) return;

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxDight = 1;
        while (max / 10 > 0) {
            maxDight++;
            max = max / 10;
        }
        System.out.println("maxDight: " + maxDight);
        int[][] buckets = new int[10][arr.length];
        int base = 10;
        for (int i = 0; i < maxDight; i++) {
            int[] bktLen = new int[10];
            for (int j = 0; j < arr.length; j++) {
                int whichBucket = (arr[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                bktLen[whichBucket]++;
            }
            int k = 0;
            for (int b = 0; b < buckets.length; b++) {
                for (int p = 0; p < bktLen[b]; p++) {
                    arr[k++] = buckets[b][p];
                }
            }
            System.out.println("Sorting:" + Arrays.toString(arr));
            base *= 10;

        }
    }

}
