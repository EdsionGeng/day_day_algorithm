package com.edison.algorithm.leetcode;

//两个数组的交集
//给定两个数组，编写一个函数来计算它们的交集。
//
//示例 1:
//
//输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2]
//示例 2:
//
//输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [9,4]
//说明:
//
//输出结果中的每个元素一定是唯一的。
//我们可以不考虑输出结果的顺序。
//————————————————
//版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/a1439775520/article/details/104745774
public class LeetCode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] container = nums1.length > nums2.length ? new int[nums1.length] : new int[nums2.length];
        boolean[] appeared = new boolean[1024];
        for (int i = 0; i < nums1.length; i++) {
            appeared[nums1[i]] = true;
        }
        int len = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (appeared[nums2[i]] == true) {
                container[len++] = nums2[i];
                appeared[nums2[i]] = false;
            }
        }
        int[] resArr = new int[len];
        for (int i = 0; i < len; i++) {
            resArr[i] = container[i];
        }
        return resArr;

    }

    public static void main(String[] args) {
        LeetCode349 le = new LeetCode349();
        int[] resArr = le.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        for (int i : resArr) {
            System.out.println(i);
        }
    }

}
