package com.edison.algorithm.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author gengyongchang
 * @create 2020-05-21 16:12
 */
public class YuesefuCircle {
    public static int lastRemaining(int n, int m) {
        if (m == 1) {
            return n - 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    public int yuesefu(int n, int m) {
        if (n == 1) {
            return 0;
        }
        return (lastRemaining(n - 1, m) + m) % n;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(10, 4));
    }
}