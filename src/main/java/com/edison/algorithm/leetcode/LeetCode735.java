package com.edison.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode735 {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asr : asteroids) {
            boolean alive = true;
            while (alive && asr < 0 && !stack.isEmpty() && stack.peek() > 0) {
                alive = stack.peek() < -asr;
                if (stack.peek() <= -asr) {
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(asr);
            }
        }
        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode735 le = new LeetCode735();
        int[] res = le.asteroidCollision(new int[]{5, -5});
        for (int i : res) {
            System.out.println(i);
        }
    }
}
