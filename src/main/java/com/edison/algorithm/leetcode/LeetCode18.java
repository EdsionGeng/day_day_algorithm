package com.edison.algorithm.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 * 四数之和
 *
 * @author gengyc
 * @create 2021-12-29 16:45
 */
public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        if (nums[0] > target / 4 || nums[len - 1] < target / 4) {
            return res;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > target / 4) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int sum = target - nums[i];
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > sum / 3) break;
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = len - 1;
                while (l < r) {
                    if (nums[r] < sum / 3) break;
                    int temp = nums[j] + nums[l] + nums[r];
                    if (temp == sum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[l] == nums[l + 1]) {
                            ;
                        }
                        l++;
                        r--;
                    } else if (temp < sum) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }

        }
        return res;
    }

}