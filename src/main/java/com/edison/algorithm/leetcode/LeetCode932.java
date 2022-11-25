package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//漂亮数组
public class LeetCode932 {

    public int[] beautifulArray(int n) {

        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < n) {
            List<Integer> l1 = res.stream().map(e -> e * 2 - 1).collect(Collectors.toList());
            List<Integer> l2 = res.stream().map(e -> e * 2).collect(Collectors.toList());
            List<Integer> l = new ArrayList<>();
            l.addAll(l1);
            l.addAll(l2);
            res = l;
        }

        return res.stream().filter(e -> e <= n).mapToInt(Integer::intValue).toArray();
    }

    public int[] beautifulArray2(int n) {

        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < n) {
            List<Integer> l1 = res.stream().map(e -> e * 2 - 1).collect(Collectors.toList());
            List<Integer> l2 = res.stream().map(e -> e * 2).collect(Collectors.toList());
            List<Integer> l = new ArrayList<>();
            l.addAll(l1);
            l.addAll(l2);
            res = l;
        }

        return res.stream().filter(e -> e <= n).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        LeetCode932 le = new LeetCode932();
        le.beautifulArray(5);
    }
}
