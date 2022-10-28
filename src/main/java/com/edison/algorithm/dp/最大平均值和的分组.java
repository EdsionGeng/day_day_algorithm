package com.edison.algorithm.dp;

import java.util.Arrays;

//相邻子数组划分
public class 最大平均值和的分组 {

    public static double largestSumOfAverage(int[] A, int K) {
        int n=A.length;
        double[] sum=new double[n+1];
        double[][] dp=new double[n+1][K+1];

        for(int i=1;i<=n;i++) {
            sum[i]=sum[i-1]+A[i-1];
            for(int k=1;k<=Math.min(i, K);k++)
                for(int j=k-1;j<i;j++) {
                    if(k==1 && j>0) break;
                    dp[i][k]=Math.max(dp[i][k], dp[j][k-1]+(sum[i]-sum[j])/(i-j));
                }
        }
        return dp[n][K];
    }

    public static void main(String[] args) {
        System.out.println(largestSumOfAverage(new int[]{9, 1, 2, 3, 9}, 3));
    }
}
