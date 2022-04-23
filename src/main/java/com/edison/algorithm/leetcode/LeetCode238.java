package com.edison.algorithm.leetcode;

/**
 * @Description TODO
 * @Date 2022/4/1下午11:59
 * @Created by edsiongeng
 */
public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int left = 1, right = 1;
        int length = nums.length;
        int[] output = new int[length];
        for (int i = 0; i <= length - 1; i++) {
            output[i] = left;
            left *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }
        return output;
    }

    public static void main(String[] args) {
        LeetCode238 le = new LeetCode238();
        int[] result = le.productExceptSelf(new int[]{1, 2, 3, 4});
        for (int i : result) {
            System.out.println(i);
        }
    }
}
