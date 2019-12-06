package com.edison.algorithm.compute;

/**
 * 描述:
 * 寻找数组中第N大元素
 *
 * @author gengyongchang
 * @create 2019-11-30 17:16
 */
public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return solve(nums, 0, n - 1, k - 1);
    }

    private static int solve(int[] nums, int l, int r, int target) {
        int p = partition(nums, l, r);
        if (p == target) {
            return nums[p];

        } else if (p > target) {
            return solve(nums, l, p - 1, target);
        } else {
            return solve(nums, p + 1, r, target);
        }

    }

    private static int partition(int[] nums, int l, int r) {
        int temp = nums[l];
        int i = l + 1, j = l;
        for (; i <= r; i++) {
            if (nums[i] > temp) {
                swap(nums, i, ++j);
            }
        }
        swap(nums, l, j);
        return j;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 7, 9, 10};
        System.out.println(findKthLargest(array, 3));
    }

}