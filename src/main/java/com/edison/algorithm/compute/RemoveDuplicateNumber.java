package com.edison.algorithm.compute;

/**
 * @Description 去除数组中重复元素
 * @Date 2019/11/28上午12:39
 * @Created by edsiongeng
 */
public class RemoveDuplicateNumber {

    /**
     * @param nums
     * @return
     */

    public static int removeDuplicate(int[] nums) {
        int k = 0;

        for (int num : nums) {
            if (k < 1 || num > nums[k - 1]) {
                nums[k++] = num;
            }

        }
        return k;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 3, 4, 3, 5};
       int result= removeDuplicate(arr);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.println(arr[i]);

        }

    }

}
