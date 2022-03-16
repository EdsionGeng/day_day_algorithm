package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 杨辉三角
 *
 * @author gengyc
 * @create 2022-01-27 14:39
 */
public class LeetCode118 {

    public List<List<Integer>> generate(int numRows) {
        int[][] array = new int[numRows][numRows];
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = null;
        for (int i = 0; i < numRows; i++) {
            array[i][0] = 1;
            list1 = new ArrayList<>();
            list1.add(array[i][0]);
            for (int j = 1; j <= i; j++) {
                array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
                list1.add(array[i][j]);

            }
            list.add(list1);
        }

        return list;
}

    public static void main(String[] args) {
        LeetCode118 le = new LeetCode118();
        List<List<Integer>> result = le.generate(6);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(" " + i + " ");
            }
            System.out.println();
        }
    }

}