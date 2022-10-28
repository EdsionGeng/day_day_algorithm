package com.edison.algorithm.dp;

import java.util.TreeMap;

public class 奇偶跳 {

    public static int oddEvenJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return n;
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        odd[n - 1] = even[n - 1] = true;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int val = arr[i];
            if (map.containsKey(val)) {
                odd[i] = even[map.get(val)];
                even[i] = odd[map.get(val)];
            } else {
                Integer lower = map.lowerKey(val);
                Integer higher = map.higherKey(val);

                if (lower != null) {
                    even[i] = odd[map.get(lower)];
                }
                if (higher != null) {
                    odd[i] = even[map.get(higher)];
                }
            }
            map.put(val, i);

        }
        int ans = 0;
        for (boolean b : odd) {
            if (b) ans++;
        }
        return ans;
    }
}
