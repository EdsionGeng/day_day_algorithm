package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 实现括号生成
 *
 * @author gengyc
 * @create 2021-12-30 14:41
 */
public class LeetCode22 {
    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     * <p>
     * 例如，给出 n = 3，生成结果为：
     * <p>
     * [
     * “((()))”,
     * “(()())”,
     * “(())()”,
     * “()(())”,
     * “()()()”
     * ]
     */
    public List<String> generateParenhesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", 0, 0, n);
        return res;
    }

    public void generate(List<String> res, String ans, int count1, int count2, int n) {
        if (count1 > n || count2 > n) return;
        if (count1 == n && count2 == n) {
            res.add(ans);
        }
        if (count1 >= count2) {
            String ans1 = new String(ans);
            generate(res, ans + "(", count1 + 1, count2, n);
            generate(res, ans1 + ")", count1, count2 + 1, n);
        }
    }

    public static void main(String[] args) {
        LeetCode22 leetCode22 = new LeetCode22();
        List<String> res = leetCode22.generateParenhesis(3);
        for (String s : res) {
            System.out.println(s);
        }
    }
}