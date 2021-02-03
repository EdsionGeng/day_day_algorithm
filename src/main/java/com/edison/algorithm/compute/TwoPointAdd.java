package com.edison.algorithm.compute;

import java.util.Arrays;

/**
 * @Description 指针相遇
 * @Date 2019/12/4下午11:59
 * @Created by edsiongeng
 */
public class TwoPointAdd {

    public static int[] twopoint(int[] num, int target) {
        int i = 0, j = num.length - 1;
        while (i < j) {
            if (num[i] + num[j] < target) {
                i++;
            } else if (num[i] + num[j] > target) {
                j--;
            } else {
                break;
            }
        }
        return new int[]{i, j};
    }

    public static void main(String[] args) {
//        int[] num = {2, 7, 9, 11};
//        int[] result = twopoint(num, 18);
//        for (int i : result) {
//            System.out.println(i);
//        }
        int[] arr = {0, 8, 7, 6, 5, 4, 3, 2, 1};
//        int[] result = merge(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(result));

        System.out.println(Arrays.toString(arr));
    }

}
