package com.edison.algorithm.offer;

import java.util.Arrays;

//n个骰子的点数
public class Offer60 {

    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;

        }
        return dp;
    }

    public static void main(String[] args) {
        Offer60 offer60 = new Offer60();
        double dp[]=offer60.dicesProbability(3);
        for (double i:dp) {
            System.out.println(i);
        }
    }
}
