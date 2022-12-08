package com.edison.algorithm.leetcode;

//字典序第K小数字
public class LeetCode440 {

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int steps = getNodes(curr, n);
            if (steps <= k) {
                k -= steps;
                curr++;
            } else {
                curr = curr * 10;
                k--;
            }
        }
        return curr;
    }

    public int getNodes(int curr, int n) {
        int totalNodes = 0;
        int  next = curr + 1;
        while (curr <= n) {
            totalNodes += Math.min(n - curr + 1, next - curr);
            next *= 10;
            curr *= 10;
        }
        return totalNodes;
    }

    public static void main(String[] args) {
        LeetCode440 le = new LeetCode440();
        System.out.println(le.findKthNumber(13, 2));
    }
}
