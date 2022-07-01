package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 计算右侧小于当前元素的个数
 * @Date 2022/4/24上午11:21
 * @Created by edsiongeng
 */
public class LeetCode315 {
    //给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 nums[i] 的元素的数量。
    //
    //示例:
    //
    //输入: [5,2,6,1]
    //输出: [2,1,1,0]
    //解释:
    //5 的右侧有 2 个更小的元素 (2 和 1).
    //2 的右侧仅有 1 个更小的元素 (1).
    //6 的右侧有 1 个更小的元素 (1).
    //1 的右侧有 0 个更小的元素.
    //————————————————
    //版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/a1439775520/article/details/104696902

    public static List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - min + 1;
        }
        int max = Integer.MIN_VALUE;
        for (int value : nums) {
            if (value > max) {
                max = value;
            }
        }
        int[] BITree = new int[max + 1];
        BITree[0] = 0;
        int[] countArr = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int count = getSum(nums[i] - 1, BITree);
            countArr[i] = count;
            update(nums[i], BITree);
        }
        List<Integer> result = new ArrayList<>();
        for (int value : countArr) {
            result.add(value);
        }
        return result;
    }

    public static int getSum(int value, int[] BITree) {
        int sum = 0;
        while (value > 0) {
            sum += BITree[value];
            value -= (value & -value);
        }
        return sum;
    }

    public static void update(int value, int[] BITree) {
        while (value <= BITree.length - 1) {
            BITree[value] += 1;
            value += (value & -value);
        }
    }

    public static void main(String[] args) {
        System.out.println(4 & -4);
        System.out.println(5 & -5);
    }
}
