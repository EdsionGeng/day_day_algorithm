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

        int i = nums1.length - 1, j = nums2.length - 1, k = nums1.length + nums2.length - 1;
        while (j >= 0) {
            nums1[k--] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 0, 0, 0, 0, 0};
        int[] b = {2, 4, 6, 8, 10};
        mergeTwoSortArray(a, 5, b, 5);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}