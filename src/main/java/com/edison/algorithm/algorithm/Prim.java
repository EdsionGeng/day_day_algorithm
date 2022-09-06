package com.edison.algorithm.algorithm;

import java.util.*;

/**
 * 描述:
 * 最小生成树算法
 *
 * @author gengyongchang
 * @create 2020-08-01 15:30
 */
public class Prim {
    public void getMinTree(int[][] G) {
        int[][] result = G;
        boolean[] vertex = new boolean[G.length];
        vertex[0] = true;
        //初始化访问过的数组
        for (int i = 1; i < G.length; i++) {
            vertex[i] = false;
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        while (list.size() < G.length) {
            int minDistance = Integer.MAX_VALUE;
            int minV = -1;
            int minI = -1;
            for (int i = 0; i < list.size(); i++) {
                int v1 = list.get(i);
                for (int j = 0; j < G.length; j++) {
                    if (vertex[j] != true) {
                        if (G[v1][j] != -1 && G[v1][j] < minDistance) {
                            minDistance = G[v1][j];
                            minV = j;
                            minI = v1;
                        }
                    }
                }
            }
            vertex[minV] = true;
            list.add(minV);
            result[minI][minV] = 0;
            result[minV][minI] = 0;
        }
        System.out.println("使用Prim算法对于给定图中顶点访问顺序为：");
        System.out.println(list);
        System.out.println("使用Prim算法，构造最小生成树的二维数组表示如下：");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " \t");
            }
            System.out.println();
        }
    }

    //    public static void main(String[] args) {
//        Prim test = new Prim();
//        int[][] G = {{-1,3,-1,-1,6,5},
//                {3,-1,1,-1,-1,4},
//                {-1,1,-1,6,-1,4},
//                {-1,-1,6,-1,8,5},
//                {6,-1,-1,8,-1,2},
//                {5,4,4,5,2,-1}};
//        test.getMinTree(G);
//    }
    public static void main(String[] args) {
        int minlenngth = 0;
        int max = 66666;
        String cityname[] = {"北京", "武汉", "南京", "上海", "杭州", "广州", "深圳"};
        int city[][] = {
                {max, 8, 7, max, max, max, max}, //北京和武汉南京联通
                {8, max, 6, max, 9, 8, max}, //武汉——北京、南京、杭州、广州
                {7, 6, max, 3, 4, max, max}, //南京——北京、武汉、上海、杭州
                {max, max, 3, max, 2, max, max}, //上海——南京、杭州
                {max, 9, 4, 2, max, max, 10}, //杭州——武汉、南京、上海、深圳
                {max, 8, max, max, max, max, 2}, //广州——武汉、深圳
                {max, max, max, max, 10, 2, max}//深圳——杭州、广州
        };// 地图
        boolean[] istrue = new boolean[7];
        Queue<Side> q1 = new PriorityQueue<>(new Comparator<Side>() {
            @Override
            public int compare(Side o1, Side o2) {
                return o1.length - o2.length;
            }
        });
        for (int i = 0; i < 7; i++) {//['
            if (city[0][i] != max) {
                istrue[0] = true;
                q1.add(new Side(city[3][i], 3, i));
            }
        }
        while (!q1.isEmpty()) {
            Side newSide = q1.poll();
            if (istrue[newSide.point1] && istrue[newSide.point2]) {
                continue;
            } else {
                if (!istrue[newSide.point1]) {
                    istrue[newSide.point1] = true;
                    minlenngth += city[newSide.point1][newSide.point2];
                    System.out.println(cityname[newSide.point1] + "连通" + cityname[newSide.point2] + ";距离为:" + city[newSide.point1][newSide.point2]);
                    for (int i = 0; i < 7; i++) {
                        if (!istrue[i]) {
                            q1.add(new Side(city[newSide.point1][i], newSide.point1, i));
                        }
                    }
                } else {
                    istrue[newSide.point2] = true;
                    minlenngth += city[newSide.point1][newSide.point2];
                    System.out.println(cityname[newSide.point1] + "连通" + cityname[newSide.point2] + ";距离为:" + city[newSide.point1][newSide.point2]);
                    for (int i = 0; i < 7; i++) {
                        if (!istrue[i]) {
                            q1.add(new Side(city[newSide.point2][i], newSide.point2, i));
                        }
                    }
                }
            }
        }
        System.out.println(minlenngth);
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