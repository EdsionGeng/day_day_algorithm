package com.edison.algorithm.dp;

import java.util.HashSet;
import java.util.Set;

public class 最长的斐波那契序列长度 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Set<Integer> s = new HashSet<>();
        for (int num : arr) {
            s.add(num);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = arr[j], y = arr[i] + arr[j];
                int length = 2;
                while (s.contains(y)) {
                    int temp = y;
                    y += x;
                    x = temp;
                    ans = Math.max(ans, ++length);
                }

            }
        }
        return ans >= 3 ? ans : 0;
    }
}
