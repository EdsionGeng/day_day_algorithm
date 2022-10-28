package com.edison.algorithm.dp;

public class 抛掷硬币 {

    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        double[] dp = new double[target + 1];


        dp[0] = 1 - prob[0];
        if (target > 0) {
            dp[1] = prob[0];
        }
        for (int i = 1; i < n; i++) {
            double[] newdp = new double[target + 1];
            newdp[0] = dp[0] * (1 - prob[i]);

            for (int j = 1; j <= target && j <= i + 1; j++) {
                newdp[j] = dp[j - 1] * prob[i] + dp[j] * (1 - prob[i]);
            }
            dp = newdp.clone();
        }
        return dp[target];
    }
}
