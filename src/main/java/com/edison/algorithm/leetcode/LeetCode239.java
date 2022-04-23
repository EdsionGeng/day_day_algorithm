package com.edison.algorithm.leetcode;

import java.util.LinkedList;

/**
 * @Description 最大滑动窗口
 * @Date 2022/4/2下午9:37
 * @Created by edsiongeng
 */
public class LeetCode239 {

    public int[] maxSlidigWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        LinkedList<Integer> list = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[i]) {
                list.pollLast();
            }
            list.addLast(i);
            if (list.peek() <= i - k) {
                list.poll();
            }
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[list.peek()];
            }

        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode239 le = new LeetCode239();
        le.maxSlidigWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
