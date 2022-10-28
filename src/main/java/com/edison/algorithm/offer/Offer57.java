package com.edison.algorithm.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Offer57 {

    public int[] twoSum(int[] nums, int target) {

        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        for (int l = 1, r = 2; l < r; ) {
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum == target) {
                int[] nums = new int[r - l + 1];
                for (int i = l; i <= r; ++i) {
                    nums[i - l] = i;
                }
                res.add(nums);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }

        }
        return res.toArray(new int[res.size()][]);

    }

    public static void main(String[] args) {
        Offer57 offer57 = new Offer57();
        int[][] res = offer57.findContinuousSequence(15);
        for (int i = 0; i <res.length; i++) {
            for (int j = 0; j <res[i].length ; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
