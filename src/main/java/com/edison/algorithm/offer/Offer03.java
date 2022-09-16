package com.edison.algorithm.offer;


import java.util.HashSet;
import java.util.Set;

//返回数组中 重复的数字
public class Offer03 {
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2,3,1,0,2,5,3}));
    }
}
