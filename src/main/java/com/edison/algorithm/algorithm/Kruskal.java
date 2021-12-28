package com.edison.algorithm.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 描述:
 * 最小生成树算法
 *
 * @author gengyc
 * @create 2021-12-10 15:54
 */
public class Kruskal {
    //并查集
    static int tree[] = new int[10];

    public static void init() {
        for (int i = 0; i < 10; i++) {
            tree[i] = -1;
        }
    }

    public static int search(int a) {
        if (tree[a] > 0) {
            return tree[a] = search(tree[a]);
        } else {
            return a;
        }
    }

    public static void union(int a, int b) {
        int a1 = search(a);
        int b1 = search(b);
        if (a1 == b1) {
            return;
        } else {
            if (tree[a1] < tree[b1]) {
                tree[a1] += tree[b1];
                tree[b1] = a1;
            } else {
                tree[b1] += tree[a1];
                tree[a1] = b1;
            }
        }
    }

    public static void main(String[] args) {
        init();
        int minlength = 0;
        int max = 66666;
        String cityname[] = {"北京", "武汉", "南京", "上海", "杭州", "广州", "深圳"};
        boolean jud[][] = new boolean[7][7];//加入边需要防止重复 比如 ba和ab等价的
        int city[][] = {
                {max, 8, 7, max, max, max, max},
                {8, max, 6, max, 9, 8, max},
                {7, 6, max, 3, 4, max, max},
                {max, max, 3, max, 2, max, max},
                {max, 9, 4, 2, max, max, 10},
                {max, 8, max, max, max, max, 2},
                {max, max, max, max, 10, 2, max}
        };// 地图
     //   boolean[] istrue = new boolean[7];
        Queue<Side> q1 = new PriorityQueue<>(new Comparator<Side>() {
            @Override
            public int compare(Side o1, Side o2) {
                return o1.length - o2.length;
            }
        });
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (!jud[i][j] && city[i][j] != max) {
                    jud[i][j] = true;
                    jud[j][i] = true;
                    q1.add(new Side(city[i][j], i, j));
                }
            }
        }
        while (!q1.isEmpty()) {
            Side newSide = q1.poll();
            int p1 = newSide.point1;
            int p2 = newSide.point2;

            if (search(p1) != search(p2)) {
                union(p1, p2);
                System.out.println(cityname[p1] + "连通" + cityname[p2]+";距离为:"+newSide.length);
                minlength += newSide.length;
            }
        }
        System.out.println(minlength);
    }

    static class Side {
        int length;
        int point1;
        int point2;

        public Side(int length, int p1, int p2) {
            this.length = length;
            this.point1 = p1;
            this.point2 = p2;
        }
    }

}