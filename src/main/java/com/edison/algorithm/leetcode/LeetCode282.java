package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Date 2022/4/15下午6:43
 * @Created by edsiongeng
 */
public class LeetCode282 {
    char[] num;
    char[] exp;
    int target;
    List<String> res;

    public List<String> addOperators(String num, int target) {
        this.res = new ArrayList<>();
        this.num = num.toCharArray();
        this.target = target;
        this.exp = new char[num.length() * 2];
        dfs(0, 0, 0, 0);
        return res;
    }

    private void dfs(int pos, int len, long prev, long curr) {
        if (pos == num.length) {
            if (curr == target) {
                res.add(new String(exp, 0, len));
            }
            return;
        }
        /**
         * s 记录该次 dfs的起始位置
         * pos是num的位置
         */
        int s = pos;
        /**
         * len是 放数字 的位置
         * l是 放运算符 的位置
         */

        int l = len;
        if (s != 0) {
            len++;
        }
        long n = 0;
        while (pos < num.length) {
            if (num[s] == '0' && pos - s > 0) {
                break;
            }
            n = n * 10 + (int) (num[pos] - '0');
            if (n > Integer.MAX_VALUE) {
                break;
            }
            exp[len++] = num[pos++];
            if (s == 0) {
                dfs(pos, len, n, n);
                continue;
            }
            exp[l] = '+';
            dfs(pos, len, n, curr + n);
            exp[l] = '-';
            dfs(pos, len, -n, curr - n);
            exp[l] = '*';
            dfs(pos, len, prev * n, curr - prev + prev * n);
        }
    }

    public static void main(String[] args) {
        LeetCode282 le = new LeetCode282();
        List<String> res = le.addOperators("232", 25);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
