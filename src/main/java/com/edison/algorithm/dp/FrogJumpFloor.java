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

    public static int gcd(int p, int q) {
        if (q== 0) {
            return p;
        }
        int r = p % q;
        return gcd(q,r);
    }

    public static void main(String[] args) {
        System.out.println(gcd(1111111,1234567));
//        System.out.println('b');
//        System.out.println('b' + 'c');
//        System.out.println((char) ('a' + 4));

//        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] result = new int[arr.length][arr.length];
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                result[i][j] = arr[j][i];
//
//            }
//        }
//
//
//        for (int i = 0; i < result.length; i++) {
//            for (int j = 0; j < result[i].length; j++) {
//                System.out.println(result[i][j]);
//            }
//        }
    }
}
