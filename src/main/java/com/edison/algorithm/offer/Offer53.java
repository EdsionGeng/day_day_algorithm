package com.edison.algorithm.offer;

//在排序数组中查找数字1
public class Offer53 {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        return binarySearch(nums, target + 1) - binarySearch(nums, target);
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) /2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Offer53 offer53 = new Offer53();
       // System.out.println(offer53.search(new int[]{5, 7, 7, 8, 8, 10}, 5));
        System.out.println(offer53.missingNumber(new int[]{0,1, 2, 3, 5}));
    }
}
