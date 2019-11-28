package com.edison.algorithm.compute;

public class MaxSubArray2 {

    /**
     * 暴力求解： 时间复杂度 n^2
     *
     * @param arr
     * @return
     */

    public static Integer maxSubArray(Integer[] arr) {
        Integer max_sum = 0;
        int min_index = 0;
        int max_index = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum > max_sum) {
                    min_index = i;
                    max_index = j;
                    max_sum = sum;
                }
            }

        }
        System.out.println(min_index + " " + max_index + " ");
        return max_sum;

    }


    public static void main(String[] args) {

    }
}
