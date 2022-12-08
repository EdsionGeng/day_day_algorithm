package com.edison.algorithm.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//找出数组比左边大比右边小的数字下标
public class byte1 {

    public Integer[] find(int[] nums) {
        if (nums.length <= 2) return new Integer[]{};
        int[] leftMax = new int[nums.length];
        Arrays.fill(leftMax, Integer.MIN_VALUE);
        int[] rightMin = new int[nums.length];
        Arrays.fill(rightMin, Integer.MAX_VALUE);

        int n = nums.length;
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i + 1]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (leftMax[i] < nums[i] && nums[i] > rightMin[i]) {
                list.add(i);
            }
        }
        return (Integer[]) list.toArray();
    }
}
