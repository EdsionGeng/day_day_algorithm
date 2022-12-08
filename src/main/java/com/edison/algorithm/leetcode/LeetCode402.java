package com.edison.algorithm.leetcode;

//移掉K位数字 input num=1432219 k=3 out:1219  explain:remove 4,3,2 形成一个最小数字1219
//input num=10200 k=1 out:200 explain:remove 1 输出前位置不能有0

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

public class LeetCode402 {
    public String removeKdigits(String num, int k) {
        Deque<Character> stk = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!stk.isEmpty() && k > 0 && stk.getLast() > c) {
                stk.pollLast();
                k--;
            }
            stk.addLast(c);
        }

        String res = stk.stream().map(Objects::toString).collect(Collectors.joining());
        res = res.substring(0, res.length() - k);
        res = res.replaceAll("^0+", "");
        return res.isEmpty() ? "0" : res;

    }

    public static void main(String[] args) {
        LeetCode402 le = new LeetCode402();
        System.out.println(le.removeKdigits("10200", 1));
    }
}
