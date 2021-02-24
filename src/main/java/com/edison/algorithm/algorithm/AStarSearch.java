package com.edison.algorithm.algorithm;

/**
 * 描述:
 * A*算法 启发式搜索
 *
 * @author gengyc
 * @create 2021-02-24 14:46
 */
public class AStarSearch {

    int[][] map;
    int startX;
    int startY;
    int endX;
    int endY;

    public AStarSearch(int[][] map, int startX, int startY, int endX, int endY) {
        this.map = map;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

    }

    public class PathNode {
        private int row;
        private int col;
        private int F = Integer.MAX_VALUE;
        //该节点的前继节点
        private PathNode parent = null;
    }

}