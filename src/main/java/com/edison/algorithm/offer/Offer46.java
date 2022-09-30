package com.edison.algorithm.offer;

//把数字翻译成字符串
public class Offer46 {

    public int translateNum(int num) {
        if (num == 0) return 1;
        return f(num);
    }

    int f(int num) {
        if (num < 10) {
            return 1;
        }
        if (num % 100 < 26 && num % 100 > 9) {
            return f(num / 10) + f(num / 100);
        } else {
            return f(num / 10);
        }
    }

    public int translateNum2(int num) {
        String str = String.valueOf(num);
        return dfs(str, 0);
    }

    public int dfs(String str, int index) {
        if (index >= str.length() - 1) {
            return 1;
        }
        int res = dfs(str, index + 1);
        String temp = str.substring(index, index + 2);
        if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
            res += dfs(str, index + 2);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("11".compareTo("25"));
    }
}
