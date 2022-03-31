package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 寻找排序数组最小值2
 *
 * @author gengyc
 * @create 2022-02-23 10:02
 */
public class LeetCode154 {
    //假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    //
    //( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    //
    //请找出其中最小的元素。
    //
    //注意数组中可能存在重复的元素。
    //
    //示例 1：
    //
    //输入: [1,3,5]
    //输出: 1
    //示例 2：
    //
    //输入: [2,2,2,0,1]
    //输出: 0
    //说明：
    //
    //这道题是 寻找旋转排序数组中的最小值 的延伸题目。
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high + low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        LeetCode154 le = new LeetCode154();
        le.findMin(new int[]{2, 2, 2, 0, 1});
    }
}