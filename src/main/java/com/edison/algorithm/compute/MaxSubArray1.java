package com.edison.algorithm.compute;

public class MaxSubArray1 {

    /**
     * 动态规划:时间复杂度n
     *
     * @param arr
     * @return
     */

    public static Integer maxSubArray(Integer[] arr) {
        Integer max_sum = Integer.MIN_VALUE;
        Integer min_index = 0;
        Integer max_index = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum < 0) {
                sum = 0;
                min_index = i;
            }
            sum += arr[i];
            if (max_sum < sum) {
                max_sum = sum;
                max_index = i;
            }

        }
        System.out.println(min_index + " " + max_index + " ");
        return max_sum;
    }

    public static int maxSubArray2(Integer[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {

        Integer[] array = new Integer[]{1, 2, -4, 5, 6};

        System.out.println(maxSubArray2(array));
    }
}
