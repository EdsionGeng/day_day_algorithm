package com.edison.algorithm.leetcode;

/**
 * @Description 丑数
 * @Date 2022/4/8下午5:52
 * @Created by edsiongeng
 */
public class LeetCode263 {

    public boolean isUgly(int num) {
        if (num < 1) return false;
        while (num % 5 == 0) {
            num /= 5;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 2 == 0) {
            num >>= 1;
        }
        if(num==1){
            return true;
        }
        return false;
    }
}
