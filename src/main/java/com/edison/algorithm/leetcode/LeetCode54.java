package com.edison.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 * 螺旋矩阵
 *
 * @author gengyc
 * @create 2022-01-13 11:15
 */
public class LeetCode54 {
    //给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
//
//示例 1:
//
//输入:
//[
//[ 1, 2, 3 ],
//[ 4, 5, 6 ],
//[ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
//示例 2:
//
//输入:
//[
//[1, 2, 3, 4],
//[5, 6, 7, 8],
//[9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix.length == 0) return result;
        int upBound = 0;
        int rightBound = matrix[0].length - 1;
        int leftBound = 0;
        int downBound = matrix.length - 1;
        while (true) {
            for (int i = leftBound; i <= rightBound; ++i) {
                result.add(matrix[upBound][i]);
            }
            if (++upBound > downBound) break;
            for (int i = upBound; i <= downBound; ++i) {
                result.add(matrix[i][rightBound]);
            }
            if (--rightBound < leftBound) break;
            for (int i = rightBound; i >= leftBound; --i) {
                result.add(matrix[downBound][i]);
            }
            if (--downBound < upBound) break;
            for (int i = downBound; i >= upBound; --i) {
                result.add(matrix[i][leftBound]);
            }
            if (++leftBound > rightBound) break;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] martix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> result=new LeetCode54().spiralOrder(martix);
        for (int i = 0; i <result.size() ; i++) {
            System.out.print(result.get(i)+" ");
        }
    }
}