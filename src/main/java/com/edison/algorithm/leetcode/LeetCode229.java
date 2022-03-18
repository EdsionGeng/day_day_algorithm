package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 求众数2
 *
 * @author gengyc
 * @create 2022-03-18 16:47
 */
public class LeetCode229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length < 1) return res;
        int num1 = nums[0];
        int count1 = 0;
        int num2 = nums[0];
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp == num1) {
                count1++;
            } else if (temp == num2) {
                count2++;
            } else if (count1 == 0) {
                count1 ++;
                num1 = temp;
            } else if (count2 == 0) {
                count2++;
                num2 = temp;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        int numSum = nums.length / 3;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp == num1) {
                count1++;
            } else if (temp == num2) {
                count2++;
            }
        }
        if (count1 > numSum) {
            res.add(num1);
        }
        if (count2 > numSum) {
            res.add(num2);
        }
        return res;

    }

    public static void main(String[] args) {
        LeetCode229 le = new LeetCode229();
        List<Integer> res = le.majorityElement(new int[]{  3, 2, 2, 2});
        for (Integer i : res
        ) {
            System.out.println(i);
        }
    }
}