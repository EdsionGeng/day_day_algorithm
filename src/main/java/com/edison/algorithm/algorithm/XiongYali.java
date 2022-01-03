package com.edison.algorithm.algorithm;

/**
 * 描述:
 * 匈牙利二分图匹配算法
 *
 * @author gengyc
 * @create 2021-12-07 14:59
 */
public class XiongYali {
    public static boolean match(int i, boolean[] vis, int[][] map, int[] p) {
        for (int j = 0; j < map.length; j++) {
            if (map[i][j] != 0 && !vis[j]) {
                vis[j] = true;
                if (p[j] == -1 || match(p[j], vis, map, p)) {
                    p[j] = i;
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int M = 4, N = 4;
        //M, N分别表示左、右侧集合的元素数量
        int map[][] = {{0, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 0, 1, 0},
                {0, 0, 0, 1}};
        int[] p = new int[N];
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            p[i] = -1;
        }
        for (int i = 0; i < M; i++) {

            boolean[] vis = new boolean[N];
            if (match(i, vis, map, p)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}