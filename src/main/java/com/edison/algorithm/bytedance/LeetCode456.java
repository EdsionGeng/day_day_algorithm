package com.edison.algorithm.bytedance;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode456 {


    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> candidate = new LinkedList<>();
        candidate.push(nums[n - 1]);
        int maxK = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] < maxK) {
                return true;
            }
            while (!candidate.isEmpty() && nums[i] > candidate.peek()) {
                maxK = candidate.pop();
            }
            if (nums[i] > maxK) {
                candidate.push(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode456 le = new LeetCode456();
        le.find132pattern(new int[]{3, 1, 4, 2});
    }
}
