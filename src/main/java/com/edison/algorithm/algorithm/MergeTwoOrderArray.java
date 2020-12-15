package com.edison.algorithm.algorithm;

/**
 * 描述:
 * 合并两个有序数组
 *
 * @author gengyongchang
 * @create 2020-08-14 15:38
 */
public class MergeTwoOrderArray {

    public static void mergeTwoSortArray(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1, k = m + n - 1;
        while (j >= 0) {
            nums1[k--] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3,4, 0, 0, 0};
        int[] b = {2, 5, 6};
        mergeTwoSortArray(a, 4, b, 3);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}