package com.edison.algorithm.offer;

//数组中的逆序对 [7,5,6,4] out:5
public class Offer51 {
    int count = 0;

    public int reversePairs(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    res += 1;
                }
            }
        }
        return res;
    }

    public int reversePairs2(int[] nums) {
        this.count = 0;
        sort(nums, 0, nums.length - 1, new int[nums.length]);
        return count;
    }


    public void sort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid, temp);
            sort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }

    }

    public void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, t = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                count += (mid - i + 1);
                temp[t++] = nums[j++];
            }

        }
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= right) {
            temp[t++] = nums[j++];
        }
        t=0;
        while (left <= right) {
            nums[left++] = temp[t++];
        }

    }

    public static void main(String[] args) {
        Offer51 offer = new Offer51();
        System.out.println(offer.reversePairs(new int[]{7, 5, 6, 4}));
    }
}
