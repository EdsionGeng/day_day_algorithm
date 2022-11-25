package com.edison.algorithm.leetcode;

/**
 * @Description 只出现一次的数字
 * @Date 2022/4/8下午4:07
 * @Created by edsiongeng
 */
public class LeetCode260 {

    public int[] singleNumber(int[] nums) {
        int key = 0;
        for (int num : nums) {
            key ^= num;
        }
        key = key == Integer.MIN_VALUE ? key : key & (-key);
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & key) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1, 2, 5};
        LeetCode260 le = new LeetCode260();
        int[] res = le.singleNumber(nums);
        for (int i : res
        ) {
            System.out.println(i);
        }
    }
}
