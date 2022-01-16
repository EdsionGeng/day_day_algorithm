package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 第K个排列
 *
 * @author gengyc
 * @create 2022-01-14 14:34
 */
public class LeetCode60 {
    public String getPermutation(int n, int k) {
        StringBuilder db = new StringBuilder();
        List<Integer> candidates = new ArrayList<>();
        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            candidates.add(i);
            fact *= i;
            factorials[i] = fact;
        }
        k -= 1;
        for (int i = n - 1; i >= 0; --i) {
            int index = k / factorials[i];
            db.append(candidates.remove(index));
            k -= index * factorials[i];

        }
        return db.toString();
    }

    public static void main(String[] args) {
        for (int i = 3; i >= 0; --i) {
            System.out.println(i);
        }
        LeetCode60 leetCode60 = new LeetCode60();
        leetCode60.getPermutation(3,3);
    }
}