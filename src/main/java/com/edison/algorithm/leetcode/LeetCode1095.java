package com.edison.algorithm.leetcode;

//山脉数组
public class LeetCode1095 {
    interface MountainArray {
        int get(int index);

        int length();
    }

    public int findMountainArray(int target, MountainArray mountainArr) {
        int l = 0, r = mountainArr.length() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int peak = l;
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1) return index;

        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);

    }

    public int binarySearch(MountainArray mountainArray, int target, int l, int r, boolean flag) {
        if (!flag) {
            target *= -1;
        }
        while (l <= r) {
            int mid = (l + r) / 2;
            int cur = mountainArray.get(mid) * (flag ? 1 : -1);
            if (cur == target) {
                return mid;
            } else if (cur < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;

    }
}
