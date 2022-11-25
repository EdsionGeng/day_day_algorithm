package com.edison.algorithm.leetcode;

//0-n整数数组，每个数只出现一次。这个数组分割成多少个子数组，增序排序后，原数组也是增序的
public class LeetCode769 {

    public int maxChunkToSorted(int[] arr) {
        int chunks = 0, curMax = 0;
        for (int i = 0; i < arr.length; i++) {
            curMax = Math.max(arr[i], curMax);
            if (curMax == i) {
                ++chunks;
            }

        }
        return chunks;
    }
}
