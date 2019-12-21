package com.edison.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 两数之和
 *
 * @author gengyongchang
 * @create 2019-12-21 14:38
 */
public class LeetCode1 {
//    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
//    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//    给定 nums = [2, 7, 11, 15], target = 9
//    因为 nums[0] + nums[1] = 2 + 7 = 9
//    所以返回 [0, 1]

    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                return new int[]{map.get(arr[i]),i};
            }
            map.put(target-arr[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 7, 8};
        int[] result = twoSum(arr, 10);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}