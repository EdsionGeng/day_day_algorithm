package com.edison.algorithm.graph;


//增广路算法
public class Karp {
    private static int[][] flow;
    private static int[][] volume;
    private static int[] a;
    private static int[] p;
    private static int start, end, sum;

    public static void main(String[] args) {

    }

    public static void inita() {
        for (int i = 0; i < end; i++) {
            a[i] = 0;
        }
    }
}
