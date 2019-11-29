package com.edison.algorithm.compute;

/**
 * @Description 三向切分 partion思想
 * @Date 2019/11/29上午1:17
 * @Created by edsiongeng
 */
public class SortColors {

    /**
     * 使用计数排序
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int[] count = {0, 0, 0};
        for (int num : nums) {
            count[num]++;
        }

        int i = 0, k = 0;

        for (int n : count) {
            while (n != 0) {
                nums[i++] = k;
                n--;
            }
            k++;
        }

        for (int n:nums
             ) {
            System.out.println(n);
        }

    }

    /**
     * 使用快速排序三向切分思想
     *
     * @param nums
     */

    public static void sortColors2(int[] nums) {
        int lt = -1, i = 0, gt = nums.length;
        while (i < gt) {
            if (nums[i] == 0) {
                swap(nums, i++, ++lt);
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, --gt);
            }
        }

        for (int num : nums
                ) {
            System.out.println(num);
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2, 1, 0, 1, 2, 1, 2};
        sortColors(nums);
    }
}
