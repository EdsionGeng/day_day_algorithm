package com.edison.algorithm.algorithm;

/**
 * @Description TODO
 * @Date 2020/7/7下午11:32
 * @Created by edsiongeng
 */
public class Lesson1 {
    public static int lg(int N) {
        if (N <= 0) {
            return -1;
        }
        if (N == 1) {
            return 0;
        }
        int result = 0;
        while (N > 1) {
            N = N / 2;
            ++result;

        }
        return result;
    }


    public static int sum(int[] arr, int n) {
        return n == 0 ? 0 : sum(arr, n - 1) + arr[n - 1];
    }

//    public static int max(int[] arr, int begin) {
//
//        return
//    }

    public static void test(boolean[][] arr) {
        int M = arr.length;
        int N = arr[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int result = gcd(i, j);
                if (result == 1) {
                    arr[i][j] = true;
                }

            }

        }
    }

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    public static int mystery(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0)
            return mystery(a + a, b / 2);
        return mystery(a + a, b / 2) + a;
    }

    public static void main(String[] args) {

        System.out.println(sum(new int[]{1, 2, 3, 4}, 4));
//        System.out.println(lg(17));
        //System.out.println(mystery(2, 25));
//        boolean[][] arr = new boolean[5][5];
//        test(arr);
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.println("i=" + i + " j=" + j);
//                System.out.println(arr[i][j]);
//
//            }
//        }
    }
}
