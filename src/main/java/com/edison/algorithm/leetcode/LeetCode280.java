package com.edison.algorithm.leetcode;

//摆动排序
public class LeetCode280 {

    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0) == (nums[i] > nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LeetCode280 le = new LeetCode280();
        le.wiggleSort(new int[]{3, 5, 2, 1, 6, 4});
        //351264
        //351624


    }
}
