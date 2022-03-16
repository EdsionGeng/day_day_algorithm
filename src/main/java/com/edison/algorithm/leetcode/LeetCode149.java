package com.edison.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 直线上最多的点数
 *
 * @author gengyc
 * @create 2022-02-15 17:27
 */
public class LeetCode149 {

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;
        if (n == 1) return 1;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            Map<String, Integer> map = new HashMap<>();
            int repeat = 0;
            int tmp_max = 0;
            for (int j = i + 1; j < n; j++) {
                int dy = points[i][1] - points[j ][1];
                int dx = points[i][0] - points[j][0];
                if (dy == 0 || dx == 0) {
                    repeat++;
                    continue;
                }
                int gcd = gcd(dy, dx);
                if (gcd != 0) {
                    dy = dy / gcd;
                    dx = dx / gcd;
                }
                String tmp = String.valueOf(dy + "/" + dx);
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                tmp_max = Math.max(tmp_max, map.get(tmp));
            }
            res = Math.max(res, repeat + tmp_max + 1);
        }
        return res;
    }
    private int gcd(int dy, int dx) {
        if (dx == 0) return dy;
        else return gcd(dx, dy % dx);
    }
    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 1}, {2, 2}, {3, 3}};
        LeetCode149 le = new LeetCode149();
        le.maxPoints(points);
    }
}