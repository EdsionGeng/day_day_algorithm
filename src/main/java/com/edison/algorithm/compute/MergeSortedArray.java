package com.edison.algorithm.compute;

/**
 * 描述:
 * 归并排序
 *
 * @author gengyongchang
 * @create 2019-11-30 16:03
 */
public class MergeSortedArray {

    public static void merge(int[] nums, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums[i] > nums2[j]) {
                nums[k--] = nums[i--];
            } else {
                nums[k--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums[k--] = nums2[j--];
        }
        for (int a : nums) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0,1,2,5,6};
        int m =3;
        int[] nums2 = {4,8,9,10};
        int n = 1;
        merge(nums1, m, nums2, n);
    }

}