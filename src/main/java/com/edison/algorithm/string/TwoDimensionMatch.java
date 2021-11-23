package com.edison.algorithm.string;

/**
 * 描述:
 * 二维字符串匹配
 *
 * @author gengyc
 * @create 2021-11-19 16:09
 */
public class TwoDimensionMatch {
    public static int casHash(int[] table, char[][] s, int nc, int nr) {
        int hashVal = 0;
        for (int i = 0; i < nc; i++) {
            for (int j = 0; j < nr; j++) {
                hashVal += table[s[i][j] - 'a'];
            }
        }
        return hashVal;
    }

    public static int casChildHash(int[] table, char[][] s, int i0, int j0, int nc, int nr) {
        int hashVal = 0;
        for (int i = i0; i < nc; ++i) {
            for (int j = j0; j < nr; ++j) {
                hashVal += table[s[i][j] - 'a'];
            }
        }
        return hashVal;
    }

    static boolean same(char[][] s, char[][] t, int i0, int j0) {
        int x = i0, y, i, j;
        for (i = 0; i < t.length; i++, ++x) {
            for (j = 0, y = j0; j < t.length; j++, ++y)
                //记得写y=j0,换行后y复位
            {
                if (s[x][y] != t[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean twoDimensionMatch(char[][] s, char[][] t) {
        int table[] = {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
                47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        //质数表对应a-z
        int n = s.length, m = t.length, hashVal, value;
        value = casHash(table, t, t.length, t.length);
        for (int i = 0; i < n - m + 1; ++i) {
            for (int j = 0; j < n - m + 1; ++j) {
                hashVal = casChildHash(table, s, i, j, m + i, m + j);
                if (value == hashVal && same(s, t, i, j)) {
                    System.out.println("i=" + i + ";j=" + j);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] s = {{'a', 'b', 'c', 'd', 'e'}, {'a', 'b', 'c', 'd', 'e'}, {'a', 'g', 'h', 'd', 'e'}, {'a', 'b', 'e', 'f', 'e'}, {'a', 'b', 'x', 'w', 'e'}};
        char[][] t = {{'e', 'f'}, {'x', 'w'}};
        twoDimensionMatch(s, t);
    }

}