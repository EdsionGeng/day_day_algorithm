package com.edison.algorithm.note;

import javax.naming.NameNotFoundException;

/**
 * @Description 并查集
 * @Date 2021/3/3下午11:24
 * @Created by edsiongeng
 */
public class Note1 {

    /**
     * 并查集 路径压缩 Size优化 Rank优化
     */


    public int[] rotate(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return nums;
        }
        int[] result = new int[nums.length];
        for (int i = 0, l = nums.length - k; i < k; i++, l++) {
            result[i] = nums[l];
        }
        for (int i = k, j = 0; i < nums.length; i++, j++) {
            result[i] = nums[j];
        }
        return result;
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        Note1 n = new Note1();
        n.rotate2(new int[]{1,2,3,4,5,6,7}, 2);
    }

}
