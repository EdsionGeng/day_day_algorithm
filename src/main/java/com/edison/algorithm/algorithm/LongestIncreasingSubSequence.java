package com.edison.algorithm.algorithm;

/**
 * 描述:
 * 最长上升子序列
 *
 * @author gengyc
 * @create 2021-03-18 16:33
 */
public class LongestIncreasingSubSequence {

    /**
     * 样例 1:
     * 输入:  [5,4,1,2,3]
     * 输出:  3
     * <p>
     * 解释:
     * LIS 是 [1,2,3]
     * <p>
     * 样例 2:
     * 输入: [4,2,4,5,3,7]
     * 输出:  4
     * <p>
     * 解释:
     * LIS 是 [2,4,5,7]
     * 算法：动态规划(dp)
     * 算法思路
     * <p>
     * 因为所求为子序列，很容易想到一种线性动态规划。
     * 对于求最长上升子序列，上升我们肯定需要知道当前阶段最后一个元素为多少，最长我们还要知道当前我们的序列有多长。
     * 那么我们就可以这样定义状态：设 dp[i] 表示以 nums[i] 为结尾的最长上升子序列的长度，为了保证元素单调递增肯定只能从 i 前面且末尾元素比 nums[i] 小的状态转移过来
     *
     * @param num
     */
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

    public static int lengthOfLIS(int[] nums) {
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

    public static void main(String[] args) {
        int[] nums = {2,6,10,11,4,5,6,9};
        System.out.println(lengthOfLIS(nums));
    }

}