package com.edison.algorithm.offer;

//构建乘积数组
public class Offer66 {
    public int[] productExceptSelf(int[] a) {
        int length = a.length;
        int[] answer = new int[length];
        answer[0] = 1;
        for (int i = 1; i <= length-1; i++) {
            answer[i] = answer[i - 1] * a[i - 1];
        }
        int r = 1;
        for (int i = length-1; i >= 0; i--) {
            answer[i] = answer[i] * r;
            r *= a[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Offer66 offer66 = new Offer66();
        offer66.productExceptSelf(new int[]{1, 2, 3, 4, 5});
    }
}
