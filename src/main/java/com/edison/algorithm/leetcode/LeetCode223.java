package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 矩形面积
 *
 * @author gengyc
 * @create 2022-03-16 17:27
 */
public class LeetCode223 {
    //在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
//
//每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
//
//Rectangle Area
//
//示例:
//
//输入: -3, 0, 3, 4, 0, -1, 9, 2
//输出: 45
//说明: 假设矩形面积不会超出 int 的范围。
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int s = 0;
        if (E >= C || G <= A || H <= B || F >= D) {
            s = 0;
        } else {
            int x1 = Math.max(A, E);
            int x2 = Math.min(C, G);

            int y1 = Math.max(B, F);
            int y2 = Math.min(D, H);
            s = (x2 - x1) * (y2 - y1);
        }
        return (C - A) * (D - B) + (G - E) * (H - F) - s;
    }
}