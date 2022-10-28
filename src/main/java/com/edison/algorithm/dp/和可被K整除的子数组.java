package com.edison.algorithm.dp;

import java.util.HashMap;

public class 和可被K整除的子数组 {

    public static int subarraysDivByK(int[] nums, int k) {
        int sum = 0, cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            cnt += map.getOrDefault(sum % k,0);
            map.put(sum % k, map.getOrDefault(sum%k,0)+1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1},5));
    }
}
