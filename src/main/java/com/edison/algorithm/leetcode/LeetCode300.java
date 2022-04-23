package com.edison.algorithm.leetcode;

/**
 * @Description TODO
 * @Date 2022/4/20下午10:38
 * @Created by edsiongeng
 */
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int res = 1;
        int maxIndex = 0;
        int left = 0;
        int right = 0;
        int middle = 0;
        for (int i = 1; i < length; ++i) {
            if (nums[i] <= dp[0]) dp[0] = nums[i];
            else if (nums[i] > dp[maxIndex]) {
                ++maxIndex;
                dp[maxIndex] = nums[i];
            } else {
                left = 0;
                right = maxIndex;
                while (left < right) {
                    if (left + 1 == right) {
                        dp[right] = nums[i];
                        break;
                    }
                    middle = (left + right) / 2;
                    if (dp[middle] == nums[i]) {
                        break;
                    } else if (dp[middle] < nums[i]) {
                        left = middle;
                    } else {
                        right = middle;
                    }

                }
            }
            res = Math.max(res, maxIndex + 1);
        }
        return res;
    }

    public static int solution(int[] num) {
        int[] dp = new int[num.length];
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j]) {
                    dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
                }
            }
            if (dp[i] > ans) {
                ans = dp[i];
            }
        }
        return ans;
    }

    public static int lengthOfLIS2(int[] nums) {
        int length[] = new int[nums.length];
        int len = 1;
        length[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int left = 0, right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (length[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            length[left] = nums[i];
            if (right == len) {
                len++;
            }
        }
        return len;
    }


    public int lengthOfLIS3(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            int left = 0, right = len;
            while (left < right) {
                int middle = left + (right - left) / 2;
                if (dp[middle] > nums[i]) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            dp[left] = nums[i];
            if (len == right) {
                len++;
            }

        }
        return len;
    }


    public static void main(String[] args) {
        LeetCode300 le = new LeetCode300();
        System.out.println(le.lengthOfLIS3(new int[]{7, 3, 6, 4, 5, 2, 8}));
    }
}
