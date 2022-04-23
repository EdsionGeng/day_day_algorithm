package com.edison.algorithm.leetcode;

/**
 * @Description 各位相加
 * @Date 2022/4/7下午4:51
 * @Created by edsiongeng
 */
public class LeetCode258 {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
