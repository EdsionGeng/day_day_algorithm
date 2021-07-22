package com.edison.algorithm.algorithm;

/**
 * @Description TODO
 * @Date 2019/12/11下午11:23
 * @Created by edsiongeng
 */
public class PackageAlgorithm {
    /**
     * 0-1背包问题
     *
     * @param capacity      背包容量
     * @param kind      物品种类
     * @param weight 物品重量
     * @param value  物品价值
     * @return
     */

    public static String zeroOnePack(int capacity, int kind, int[] weight, int[] value) {
        int[][] dp = new int[capacity + 1][kind + 1];
        for (int i = 1; i < capacity + 1; i++) {
            for (int j = 1; j < kind + 1; j++) {

                if (weight[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }
            }

        }
        int maxValue = dp[capacity][kind];
        int j = kind;
        String numStr = "";
        for (int i = capacity; i > 0; i--) {
            if (dp[i][j] > dp[i - 1][j]) {
                numStr = i + " " + numStr;
                j = j - weight[i - 1];
            }
            if (j == 0) {
                break;
            }
        }
        return numStr;

    }

    /**
     * 0-1背包优化解法
     * 思路：只用一个一维数组记录状态，dp[i]表示容量为i 的背包所能装入物品的最大价值
     * 用逆序来实现
     * @param capacity
     * @param kind
     * @param weight
     * @param value
     * @return
     */

    public static int zeroOnePack2(int capacity, int kind, int[] weight, int[] value) {
        int[] dp = new int[capacity + 1];
        for (int i = 1; i < kind + 1; i++) {
            for (int j = capacity; j < weight[i - 1]; j--) {
                dp[j] = Math.max(dp[j - weight[i - 1]] + value[i - 1], dp[j]);
            }
        }
        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] weight={1,2,3};
        int[] value={2,2,2};
        System.out.println(zeroOnePack2(5,3,weight,value));
    }

}
