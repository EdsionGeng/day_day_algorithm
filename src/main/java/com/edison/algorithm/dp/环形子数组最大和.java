package com.edison.algorithm.dp;

public class 环形子数组最大和 {

    public static int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int ans1 = kadane(nums, 0, nums.length - 1, 1);
        int ans2 = sum + kadane(nums, 1, nums.length - 2, -1);
        return Math.max(ans1, ans2);
    }

    public static int kadane(int[] nums, int i, int j, int sign) {
        int ans = Integer.MIN_VALUE;
        int cur = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            cur = sign * nums[k] + Math.max(cur, 0);
            ans = Math.max(ans, cur);

        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{-3, -2, -3}));
    }
}
