package com.edison.algorithm.leetcode;

//区间和的个数
public class LeetCode327 {

    int[] sum;

    public int countRangeSum(int[] nums, int lower, int upper) {
        range(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j <nums.length; j++) {
                int res = sum[j + 1] - sum[i];
                if (res >= lower && res <= upper) {
                    System.out.println(res);
                    System.out.println(i+"=="+j);
                    count+=1;
                }

            }
        }
        return count;

    }

    public void range(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public static void main(String[] args) {
        LeetCode327 le = new LeetCode327();
        System.out.println(le.countRangeSum(new int[]{-2147483647,0,-2147483647,2147483647}, -564, 3864));
    }
}
