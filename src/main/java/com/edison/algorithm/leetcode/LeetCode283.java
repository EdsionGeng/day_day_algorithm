package com.edison.algorithm.leetcode;

/**
 * @Description TODO
 * @Date 2022/4/17上午12:31
 * @Created by edsiongeng
 */
public class LeetCode283 {
    public int[] moveZeroToEnd(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }

        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
        return nums;
    }

    public static void main(String[] args) {
        LeetCode283 le = new LeetCode283();
        int[] res = le.moveZeroToEnd(new int[]{0, 7, 5, 0, 4});
        for (int i : res
                ) {
            System.out.println(i);
        }
    }
}
