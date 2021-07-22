package com.edison.algorithm.struct;

import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        Prim test = new Prim();
        int[][] G = {{-1,3,-1,-1,6,5},
                {3,-1,1,-1,-1,4},
                {-1,1,-1,6,-1,4},
                {-1,-1,6,-1,8,5},
                {6,-1,-1,8,-1,2},
                {5,4,4,5,2,-1}};
        test.getMinTree(G);
    }

}