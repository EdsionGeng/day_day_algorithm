package com.edison.algorithm.leetcode;

//给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
//我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]
//
//示例 1:
//
//输入: nums = [4,2,3]
//输出: true
//解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
//
//关于该题，写这题的原因在于，这题让我回忆起高中的关于非严格递增的定义，觉得很好玩。
public class LeetCode665 {

    public static boolean checkPossibility(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] > nums[i + 1]) {
                count++;
                if (i + 2 < nums.length && nums[i] > nums[i + 2] && i - 1 >= 0 && nums[i - 1] > nums[i + 1]) {
                    return false;
                }
            }
            if (count > 1) {
                return false;
            }


        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{2,3,6,5,7}));
    }
}
