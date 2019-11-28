package com.edison.algorithm.compute;

/**
 * @Description 将数组中的 0 移动到数组末尾，保持非零元素的原有顺序。不得使用其他数据结构
 * @Date 2019/11/27下午11:33
 * @Created by edsiongeng
 */
public class MoveZeros {

    /**
     * version1
     * 思路：for循环 用数组下标从零开始接收不为零的数值，
     * k++记录下标位置，最后剩下的都进行补零操作
     * 时间复杂度 O(n) , 空间复杂度 O(n)
     *
     * @param nums
     * @return
     */

    public static int[] method1(int[] nums) {


        int n = nums.length;
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }

        }
        while (k < n) {
            nums[k++] = 0;

        }
        return nums;

    }

    /**
     * version2
     * 大体思路跟方法一一致，区别就是最后不用补0。交换0和不为0的下标位置，实现功能
     * 时间复杂度O(n)，空间复杂度O(1)
     *
     * @param nums
     * @return
     */
    public static int[] method2(int[] nums) {

        int n = nums.length;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                if (i != k) {
                    swap(nums, i, k++);
                }else{
                    k++;
                }
            }

        }
        return nums;

    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 7, 0, 5, 0};
        int[] result = method2(nums);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

        }
    }


}
