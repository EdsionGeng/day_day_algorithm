package com.edison.algorithm.compute;


/**
 * @author by edsiongeng
 * @Description 假定数组中只有 0，1，2，对此数组进行排序。
 * @Date 2019/11/29上午1:17
 */
public class SortColors {

    /**
     * 使用计数排序
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int[] count = {0, 0, 0};
        //先统计 0,1,2 三个数共出现的次数
        for (int num : nums) {
            count[num]++;
        }
        int i = 0, k = 0;
        //遍历count，
        for (int n : count) {
            //判断值总共次数肯定不为0 ，下标索引++，然后 n-- 控制当前值应该赋值次数，
            //while循环结束 ,k++ 代表上一值已结束，进行下一次值的赋予 0 ->1 ->2
            while (n != 0) {
                nums[i++] = k;
                n--;
            }
            k++;
        }
    }

    /**
     * 使用快速排序三向切分思想
     *
     * @param nums
     */
    public static void sortColors2(int[] nums) {
        int lt = -1, i = 0, gt = nums.length;
        //大体思路：就是遇到0和左边交换值，遇到2和右边交换值，1不变
        // lt 控制 0的下标+1 ，gt控制2的下标-1

        while (i < gt) {
            if (nums[i] == 0) {
                swap(nums, i++, ++lt);
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, --gt);
            }
            //误区：最开始本猿想为什么等于0的时候 swap的i要++，等于2为啥不要
            //原因：2是和索引的最后下标交换值，--gt控制着上次交换的索引下标，循环条件--gt等于是i++了
        }
        for (int n : nums) {
            System.out.println(n);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (arr[i] != arr[j]) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2,1,1,0,0};
        sortColors2(nums);
    }
}
