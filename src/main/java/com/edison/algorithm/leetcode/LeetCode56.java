package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 描述:
 * 合并区间
 *
 * @author gengyc
 * @create 2022-01-13 14:25
 */
public class LeetCode56 {
    //给出一个区间的集合，请合并所有重叠的区间。
    //
    //示例 1:
    //
    //输入: [[1,3],[2,6],[8,10],[15,18]]
    //输出: [[1,6],[8,10],[15,18]]
    //解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
    //示例 2:
    //
    //输入: [[1,4],[4,5]]
    //输出: [[1,5]]
    //解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间


    public static int[][] merge(int[][] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int i = 0;
        int n = arr.length;
        while (i < n) {
            int left = arr[i][0];
            int right = arr[i][1];
            while (i < n - 1 && right >= arr[i + 1][0]) {
                right = Math.max(right, arr[i + 1][1]);
                i++;
            }
            list.add(new int[]{left, right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        merge(new int[][]{{1,4},{4,5},{3,6}});
    }

}