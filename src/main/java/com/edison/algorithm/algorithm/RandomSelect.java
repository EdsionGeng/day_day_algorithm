package com.edison.algorithm.algorithm;

import java.util.Random;

/**
 * 描述:
 * 随机选择算法
 *
 * @author gengyc
 * @create 2021-12-09 16:22
 */
public class RandomSelect {
    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static int randPartition(int[] A, int left, int right) {
        int p = new Random().nextInt(right - left + 1) + left;
        swap(A, left, p);
        return 0;
    }

    public static void randSelect(int[] A, int left, int right, int K) {
        if (left == right) return;
        int p = randPartition(A, left, right);
        int M = p - left + 1;
        if (M == K) {

        }
    }




}