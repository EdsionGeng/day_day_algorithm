package com.edison.algorithm.algorithm;

/**
 * 描述:
 * 寻找数组第二小元素
 *
 * @author gengyongchang
 * @create 2020-08-14 15:22
 */
public class SecondSmallElement {

    public static int findSecondSmallElement(int[] array) {
        int  first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

        for (int j = 0; j < array.length; j++) {
            if (array[j] > first) {
                first = array[j];
            } else if (array[j] > second && array[j] != first) {
                second = array[j];
            }
        }
        if (second == Integer.MIN_VALUE) {
            return -1;
        }
        return second;
    }

    public static void main(String[] args) {
        int[] array = {7, 5, 1, 2, 3, 4};
        int result = findSecondSmallElement(array);
        System.out.println(result);
    }

}