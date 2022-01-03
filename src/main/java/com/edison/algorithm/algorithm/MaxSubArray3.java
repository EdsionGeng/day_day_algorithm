
package com.edison.algorithm.algorithm;
public class MaxSubArray3 {


    /**
     * 递归算法：将数组一分为2，最大子数组要么在左边部分要么在右边部分，要么穿过中点，时间复杂度N*logN
     *
     * @param A
     * @param low
     * @param high
     * @return
     */
    public static Integer[] find_maxium_subarray(Integer[] A, int low, int high) {
        if (high == low) {
            return new Integer[]{low, high, A[low]};
        } else {
            int mid = (low + high) / 2;
            Integer[] l_maximum_subarray = find_maxium_subarray(A, low, mid);
            Integer[] r_maximum_subarray = find_maxium_subarray(A, mid + 1, high);
            Integer[] crossing_subarray = find_max_crossing_subarray(A, low, mid, high);
            if (l_maximum_subarray[2] >= r_maximum_subarray[2] && l_maximum_subarray[2] >= crossing_subarray[2]) {
                return l_maximum_subarray;
            } else if (r_maximum_subarray[2] >= l_maximum_subarray[2] && l_maximum_subarray[2] >= crossing_subarray[2]) {
                return r_maximum_subarray;
            } else {
                return crossing_subarray;
            }
        }
    }


    public static Integer[] find_max_crossing_subarray(Integer[] A, int low, int mid, int high) {
        int left_sum = 0;
        int sum = 0;
        int max_left = 0;

        for (int i = mid; i >= low; i--) {
            sum += A[i];
            if (sum > left_sum) {
                left_sum = sum;
                max_left = i;
            }

        }
        int right_sum = 0;
        int max_right = 0;
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum = sum + A[j];
            if (sum > right_sum) {
                right_sum = sum;
                max_right = j;
            }

        }
        return new Integer[]{max_left, max_right, left_sum + right_sum};
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 5, -7, 6, 4, -8};
        Integer[] result = find_maxium_subarray(arr, 0, 5);

        for (Integer i : result) {
            System.out.println(i);
        }

    }
}
