package com.edison.algorithm.leetcode;


import java.util.Stack;

/**
 * 描述:
 * 最大矩形
 *
 * @author gengyc
 * @create 2022-01-19 15:51
 */
public class LeetCode85 {
    //给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
//示例:
//
//输入:
//[
//[“1”,“0”,“1”,“0”,“0”],
//[“1”,“0”,“1”,“1”,“1”],
//[“1”,“1”,“1”,“1”,“1”],
//[“1”,“0”,“0”,“1”,“0”]
//]
//输出: 6
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] height = new int[matrix[0].length];
        int globalmax = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') height[j] = 0;
                else height[j]++;
            }
            globalmax = Math.max(globalmax, maxRow(height));
        }
        return globalmax;
    }

    public int maxRow(int[] height) {
        Stack<Integer> st = new Stack<>();
        int localmax = 0;
        for (int i = 0; i <= height.length; i++) {
            int h = (i == height.length) ? 0 : height[i];
            while (!st.isEmpty() && height[st.peek()] >= h) {
                int maxHeight = height[st.pop()];
                int area = st.isEmpty() ? i * maxHeight : maxHeight * (i - st.peek() - 1);
                localmax = Math.max(localmax, area);
            }
            st.push(i);
        }
        return localmax;
    }

    public static void main(String[] args) {
        char[][] c = new char[][]{{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        LeetCode85 leetCode85 = new LeetCode85();
        System.out.println(leetCode85.maximalRectangle(c));
    }
}