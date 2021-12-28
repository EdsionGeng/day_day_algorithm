package com.edison.algorithm.search;

/**
 * @Description 二分查找
 * @Date 2020/8/25下午10:58
 * @Created by edsiongeng
 */
public class BinarySearch {

    /**
     * 常规二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }


    /**
     * 1,2,2,2,3  寻找最左边界下标
     *
     * @param nums
     * @param target
     * @return
     */
    public int leftBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;

    }

    /**
     * 二分查找寻找最右值
     * @param nums
     * @param target
     * @return
     */

    public int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;

            }
        }

        if (left > nums.length || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int nums[] = {1, 2, 2, 2, 3};
        System.out.println(binarySearch.rightBound(nums, 2));
    }
}
