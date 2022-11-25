package com.edison.algorithm.math;

import java.util.HashMap;
import java.util.Map;

public class 直线上最多的点数 {
    public static int maxPoints(int[][] points) {
        Map<Float, Integer> map = new HashMap<>();
        int result = 1;

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                float x = points[i][0] - points[j][0];
                float y = points[i][1] - points[j][1];
                float l;
                if (x == 0) l = Integer.MIN_VALUE;
                else l = y / x;

                if (map.get(l) == null) map.put(l, 2);
                else map.put(l, map.get(l) + 1);


            }
            for (Map.Entry<Float, Integer> entry : map.entrySet()) {
                result = Math.max(result, entry.getValue());
            }
            map.clear();

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.out.println(maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
    }
}
