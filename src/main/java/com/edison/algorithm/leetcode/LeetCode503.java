package com.edison.algorithm.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//下一个元素2
public class LeetCode503 {

    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();

        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);

        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode503 le = new LeetCode503();
        int[] res = le.nextGreaterElements(new int[]{1, 2, 3, 4, 3});
        for (int i :res) {
            System.out.println(i);
        }
    }
}
