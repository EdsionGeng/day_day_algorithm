package com.edison.algorithm.dp;

/**
 * @Description TODO
 * @Date 2020/7/2下午11:18
 * @Created by edsiongeng
 */
public class FrogJumpFloor {


    public static int jump(int floor) {
        if (floor < 0) {
            return 0;
        }
        if (floor <= 2) {
            return floor;
        }
        int[] dp = new int[floor + 1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= floor; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[floor];
    }
}
