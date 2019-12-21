package com.edison.algorithm.compute;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述:
 * 幸福数
 *
 * @author gengyongchang
 * @create 2019-12-14 16:11
 */
public class HappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int result = countSquare(n);
        while (true) {
            if (result == 1) {
                return true;
            }
            if (set.contains(result)) {
                return false;
            } else {
                set.add(result);
            }
            result = countSquare(result);
        }
    }

    public static int countSquare(int n) {
        int result = 0;
        while (n != 0) {
            int temp = n % 10;
            n /= 10;
            result += temp * temp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}