package com.edison.algorithm.algorithm;

/**
 * @Description 移除元素
 * @Date 2021/10/3上午9:32
 * @Created by edsiongeng
 */
public class RemoveElement {

    public static int removeElement(int[] arr, int val) {

        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < arr.length; fastIndex++) {
            if (arr[fastIndex] != val) {
                arr[slowIndex++] = arr[fastIndex];
            }
        }

        return slowIndex;


    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 2, 4, 3, 1, 3};

        System.out.println(removeElement(arr,4));
    }

}
