package com.edison.algorithm.leetcode;

import java.util.Random;

//在园内随机生成点
public class LeetCode478 {

    class Solution {
        Random random;
        double xc, yc, r;

        public Solution(double radius, double x_center, double y_center) {
            random = new Random();
            xc = x_center;
            yc = y_center;
            r = radius;
        }

        public double[] randPoint() {
            while (true) {
                double x = random.nextDouble() * (2 * r) - r;
                double y = random.nextDouble() * (2 * r) - r;
                if (x * x + y * y <= r * r) {
                    return new double[]{xc + x, yc + y};
                }
            }
        }
    }
}
