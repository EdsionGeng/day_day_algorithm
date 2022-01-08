package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 缺失的第一个正数
 *
 * @author gengyc
 * @create 2022-01-07 10:59
 */
public class LeetCode41 {
    //想法：因为题目规定不能开辟额外的空间，所以，考虑到遍历数组，n为数组长度。如果nums[i]大于零且数字在n以内，且没有在应该的位置，
    //将其放到其规定的位置，有点像分好了n个桶，将该位置的数字放到其应该在的桶。然后再遍历一次数组，看看第一个不符合的桶，
    //返回。如果所有的n个数都在其正确的位置，那么第一个缺失的数就是n+1。
    //输入: [1,2,0]
    //输出: 3
    //示例 2:
    //
    //输入: [3,4,-1,1]
    //输出: 2
    //示例 3:
    //
    //输入: [7,8,9,11,12]
    //输出: 1
    public static int firstMissingPositive(int[] nums) {
        int[] m = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                m[nums[i]] = 1;
            }
        }
        for (int i = 1; i < m.length; i++) {
            if (m[i] == 0) return i;
        }
        return m.length;
    }

    public static void main(String[] args) {
        int[] nums={3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
}