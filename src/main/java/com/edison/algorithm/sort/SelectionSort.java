package com.edison.algorithm.sort;

public class SelectionSort {

    public int[] selectionSort(int[] nums) {
        int mid = 0;

        for (int i = 0; i < nums.length; i++) {
            mid = i;
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[j] < nums[mid]) {
                    mid = j;
                }
            }
            swap(nums, mid, i);
        }

        return nums;


    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] nums = selectionSort.selectionSort(new int[]{7, 5, 8, 9, 4, 2});

    }

}
