package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashSet;
import java.util.List;

/**
 * 描述:
 * 三数之和
 *
 * @author gengyc
 * @create 2021-12-27 15:24
 */
public class LeetCode15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] > 0) {
                break;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int s = nums[i] + nums[left] + nums[right];
                if (s > 1) {
                    right--;
                } else if (s < 1) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums);
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}