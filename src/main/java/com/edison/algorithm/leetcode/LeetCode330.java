package com.edison.algorithm.leetcode;

public class LeetCode330 {
    public int minPatches(int[] nums, int n) {
        int patches = 0, i = 0;
        long miss = 1;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                patches++;
            }
        }
        return patches;
    }

    public static void main(String[] args) {
        LeetCode330 le = new LeetCode330();
        System.out.println(le.minPatches(new int[]{1,5,10},20));
    }
}
