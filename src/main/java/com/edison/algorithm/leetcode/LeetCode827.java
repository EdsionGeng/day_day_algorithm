package com.edison.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/making-a-large-island/submissions/
//在二维地图上， 0代表海洋， 1代表陆地，我们最多只能将一格 0 海洋变成 1变成陆地。
//进行填海之后，地图上最大的岛屿面积是多少？（上、下、左、右四个方向相连的 1 可形成岛屿）
//
//示例 1:
//输入: [[1, 0], [0, 1]]
//输出: 3
//解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
//
//示例 2:
//输入: [[1, 1], [1, 0]]
//输出: 4
//解释: 将一格0变成1，岛屿的面积扩大为 4。
//
//示例 3:
//输入: [[1, 1], [1, 1]]
//输出: 4
//解释: 没有0可以让我们变成1，面积依然为 4。
//
//说明:
//1 <= grid.length = grid[0].length <= 50
//0 <= grid[i][j] <= 1
//
//这道题开始有个想法就是，随机找个岛，然后往外拓展一格，但是有个问题，就是在判断拓展哪一个格子时候，陷入了困境。
//然后想到，既然要拓展格子，为什么就只判断海洋格子呢。
//所以只要先标记一个一个岛屿，然后在判断每一个海洋格子如果填海，那它及附近的陆地面积会是多少
//————————————————
//版权声明：本文为CSDN博主「孤竹彧」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/qq_33321609/article/details/100110344
public class LeetCode827 {

    Map<Integer, Integer> map = new HashMap<>();

    public int largestIsland(int[][] grid) {
        int rn = grid.length;
        int key = 1;
        for (int i = 0; i < rn; i++) {
            for (int j = 0; j < rn; j++) {
                if (grid[i][j] == 1) {
                    int v = changeTo(grid, i, j, ++key);
                    map.put(key, v);
                }

            }
        }
        //如果key是0，值也是0
        map.put(0, 0);
        int max = 0;
        for (int i = 0; i < rn; i++) {
            for (int j = 0; j < rn; j++) {
                if (grid[i][j] == 0) {
                    int ans = getAns(grid, i, j);
                    max = Math.max(max, ans);
                }
            }
        }
        if (max == 0) {
            // 说明没有0
            return rn * rn;
        }
        return max;

    }

    //如果(i,j)是陆地的话，面积是多大
    public int getAns(int[][] grid, int i, int j) {
        int ans = 1;
        int x1 = 0, x2 = 0, x3 = 0, x4 = 0;
        if (i > 0) {
            x1 = grid[i - 1][j];
            ans += map.get(x1);
        }
        if (j > 0) {
            x2 = grid[i][j - 1];
            if (x2 != x1) {
                ans += map.get(x2);
            }
        }
        if (i < grid.length - 1) {
            x1 = grid[i + 1][j];
            if (x3 != x2 && x2 != x1) {
                ans += map.get(x3);
            }

        }
        if (j < grid[0].length - 1) {
            x4 = grid[i][j + 1];
            //防止同一个岛屿被计算两次，所以要先判断
            if (x4 != x1 && x4 != x2 && x4 != x3) {
                ans += map.get(x4);
            }
        }
        return ans;
    }


    public int changeTo(int[][] grid, int i, int j, int key) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = key;
        int ans = 1;
        ans += changeTo(grid, i + 1, j, key);
        ans += changeTo(grid, i - 1, j, key);
        ans += changeTo(grid, i, j + 1, key);
        ans += changeTo(grid, i, j - 1, key);
        return ans;
    }

}
