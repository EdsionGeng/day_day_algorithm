package com.edison.algorithm.compute;

/**
 * @Description 矩阵API
 * @Date 2020/7/8下午11:37
 * @Created by edsiongeng
 */
public class Martix {


    public int findKthLargest(int[] nums, int k) {
        if (nums.length < 2) {
            return nums.length == 1 ? nums[0] : -1;
        }

        int max = 0, min = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int length = max - min + 1;
        int[] newArray = new int[length];
        for (int i = 0; i < nums.length; i++) {
            newArray[nums[i] - min]++;
        }

        int j = 0;
        for (int i = length - 1; i >= 0; i--) {
            j = newArray[i] + j;
            if (j >= k) {
                return i + min;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 8, 5, 9};
        Martix martix = new Martix();
        System.out.println(martix.findKthLargest(nums, 3));
    }
}
