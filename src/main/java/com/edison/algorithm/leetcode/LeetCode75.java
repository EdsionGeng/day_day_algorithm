package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 颜色分类
 *
 * @author gengyc
 * @create 2022-01-17 16:40
 */
public class LeetCode75 {
    //给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//注意:
//不能使用代码库中的排序函数来解决这道题。
//
//示例:
//
//输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2]
//进阶：
//
//一个直观的解决方案是使用计数排序的两趟扫描算法。
//首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
    public int[] sortColors(int[] nums) {
        int low = 0, high = nums.length - 1;
        int i = 0;
        while (i <= high) {
            if (nums[i] == 0) {
                int temp = nums[low];
                nums[low] = nums[i];
                nums[i] = temp;
                low++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                int temp = nums[high];
                nums[high] = nums[i];
                nums[i] = temp;
                high--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        LeetCode75 le = new LeetCode75();
        System.out.println(le.sortColors(new int[]{2, 0, 2, 1, 1, 0}));
    }
}