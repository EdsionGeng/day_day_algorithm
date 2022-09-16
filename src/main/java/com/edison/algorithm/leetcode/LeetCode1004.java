package com.edison.algorithm.leetcode;

//最大连续1的个数 input nums=[1,1,1,0,0,0,1,1,1,1,0] 输出6 explain[1,1,1,0,0,1,1,1,1,1,1]
public class LeetCode1004 {

    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r++] == 0) k--;
            if (k < 0 && nums[l++] == 0) k++;
        }
        return r - l;
    }

    public static void main(String[] args) {
        LeetCode1004 le = new LeetCode1004();
        System.out.println(le.longestOnes(new int[]{0, 0, 0, 0}, 0));
    }
}
