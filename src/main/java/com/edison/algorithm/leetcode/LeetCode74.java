package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 搜索二维矩阵
 *
 * @author gengyc
 * @create 2022-01-17 16:10
 */
public class LeetCode74 {
    //编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
    //
    //每行中的整数从左到右按升序排列。
    //每行的第一个整数大于前一行的最后一个整数。
    //示例 1:
    //
    //输入:
    //matrix = [
    //[1, 3, 5, 7],
    //[10, 11, 16, 20],
    //[23, 30, 34, 50]
    //]
    //target = 3
    //输出: true
    //示例 2:
    //
    //输入:
    //matrix = [
    //[1, 3, 5, 7],
    //[10, 11, 16, 20],
    //[23, 30, 34, 50]
    //]
    //target = 13
    //输出: false
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int begin, mid, end;
        begin = mid = 0;
        int len1 = matrix.length, len2 = matrix[0].length;
        end = len1 * len2 - 1;
        while (begin < end) {
            mid = (begin + end) / 2;
            if (matrix[mid / len2][mid % len2] < target) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return matrix[begin / len2][begin % len2] == target;
    }

    public static void main(String[] args) {
        int[][] martix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
    }

}