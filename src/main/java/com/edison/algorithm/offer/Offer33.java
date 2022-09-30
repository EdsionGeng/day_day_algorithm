package com.edison.algorithm.offer;

import java.util.ArrayDeque;
import java.util.Deque;

//二叉搜索树后序遍历序列
public class Offer33 {

    public boolean verifyPostorder(int[] poster) {
        return recur(poster, 0, poster.length - 1);
    }

    boolean recur(int[] postorder, int start, int end) {
        if (start >= end) return true;
        int index = start;
        while (postorder[index] < postorder[end]) index++;
        int m = index;
        while (postorder[index] > postorder[end]) index++;
        return index == end && recur(postorder, start, m - 1) && recur(postorder, m, end - 1);
    }

    public boolean verifyPostorder2(int[] poster) {
        Deque<Integer> stack = new ArrayDeque<>();
        int root = Integer.MAX_VALUE;
        for (int i = poster.length - 1; i >= 0; i--) {
            if (poster[i] > root) return false;
            while (!stack.isEmpty() && stack.peek() > poster[i]) {
                root = stack.pop();
            }
            stack.add(poster[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Offer33 offer = new Offer33();
        System.out.println(offer.verifyPostorder(new int[]{5, 6, 2, 3, 1}));
        System.out.println(offer.verifyPostorder2(new int[]{5, 6, 2, 3, 1}));
    }
}
