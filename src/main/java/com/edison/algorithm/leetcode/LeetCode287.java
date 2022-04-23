package com.edison.algorithm.leetcode;

/**
 * @Description 寻找重复数
 * @Date 2022/4/17下午2:27
 * @Created by edsiongeng
 */
public class LeetCode287 {

    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }

    public static void main(String[] args) {
        LeetCode287 le = new LeetCode287();
        int res = le.findDuplicate(new int[]{1, 2, 3, 4, 2, 7, 6, 5});
        System.out.println(res);
    }

}
