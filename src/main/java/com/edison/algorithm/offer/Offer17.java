package com.edison.algorithm.offer;

//打印从1到最大n位数
public class Offer17 {
    public int[] printNumbers(int n) {
        int max = (int) Math.pow(10, n);
        int num[] = new int[max - 1];
        for (int i = 1; i <max; i++) {
            num[i - 1] = i;
        }
        return num;
    }
}
