package com.edison.algorithm.leetcode;

//第一个错误的版本
public class LeetCode278 {
    boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;

    }
}
