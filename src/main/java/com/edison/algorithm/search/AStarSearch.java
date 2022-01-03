package com.edison.algorithm.search;

import lombok.Data;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 描述:
 * A*算法 启发式搜索
 *
 * @author gengyc
 * @create 2021-02-24 14:46
 */
public class AStarSearch {

    public static void main(String[] args) {
        int[][] map = {
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, -1, 0, 0, 0, -1},
                {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
                {-1, 0, 1, 0, -1, 0, 0, 2, 0, -1},
                {-1, 0, 0, 0, 0, -1, 0, 0, 0, -1},
                {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, -1, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
        };
        Node start = new Node(4, 2);
        start.father = null;
        Node end = new Node(4, 7);
        Solution solution = new Solution();
        Node res_node = solution.astarSearch(start, end);
        //渲染迷宫
        while (res_node != null) {
            map[res_node.x][res_node.y] = 12;
            res_node = res_node.father;
            //迭代操作
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%3d", map[i][j]);
            }
            System.out.println();
        }
    }

    @Data
    static class Solution {
        //地图 -1 代表墙壁， 1代表起点，2代表终点
        public int[][] map = {
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, -1, 0, 0, 0, -1},
                {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
                {-1, 0, 1, 0, -1, 0, 0, 2, 0, -1},
                {-1, 0, 0, 0, 0, -1, 0, 0, 0, -1},
                {-1, 0, 0, 0, -1, 0, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, -1, 0, 0, 0, -1},
                {-1, 0, 0, 0, 0, 0, 0, 0, 0, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
        };

        private Queue<Node> open = new PriorityQueue<>();
        private ArrayList<Node> close = new ArrayList<>();
        private ArrayList<Node> exist = new ArrayList<>();

        public Node astarSearch(Node start, Node end) {
            this.open.add(start);
            this.exist.add(start);
            while (open.size() > 0) {
                Node currentNode = open.poll();
                close.add(currentNode);
                ArrayList<Node> neighbourNode = extendCurrentNode(currentNode);
                for (Node node : neighbourNode) {
                    if (node.x == end.x && node.y == end.y) {
                        node.init_node(currentNode, end);
                        return node;
                    }
                    if (!isExist(node)) {
                        node.init_node(currentNode, end);
                        open.add(node);
                        exist.add(node);
                    }
                }
            }
            return null;
        }

        public ArrayList<Node> extendCurrentNode(Node currentNode) {
            int x = currentNode.x;
            int y = currentNode.y;
            ArrayList<Node> neighbourNode = new ArrayList<>();
            if (isValid(x + 1, y)) {
                Node node = new Node(x + 1, y);
                neighbourNode.add(node);
            }
            if (isValid(x - 1, y)) {
                Node node = new Node(x - 1, y);
                neighbourNode.add(node);
            }
            if (isValid(x, y + 1)) {
                Node node = new Node(x, y + 1);
                neighbourNode.add(node);
            }
            if (isValid(x, y - 1)) {
                Node node = new Node(x, y - 1);
                neighbourNode.add(node);
            }
            return neighbourNode;
        }

        public boolean isValid(int x, int y) {
            if (map[x][y] == -1) {
                return false;
            }
            for (Node node : exist) {
                if (isExist(new Node(x, y))) {
                    return false;
                }
            }
            return true;
        }

        public boolean isExist(Node node) {
            for (Node existNode : exist) {
                if (node.x == existNode.x && node.y == existNode.y) {
                    return true;
                }
            }
            return false;
        }
    }

    @Data
    static class Node implements Comparable<Node> {
        /**
         * x坐标
         * y坐标
         * G：从起点格子走到现在的格子需要花费多少步（已经花了的步数）
         * <p>
         * H：不考虑障碍的情况下，从当前在的格子走到终点需要花费的步数（预估仍然需要花的步数）
         * <p>
         * F：对G和H的综合评估，也就是路径上如果拥有这个格子的话，最终需要花费的步数数量的预估
         * F=G+H
         */
        private int x;
        private int y;
        private int F;
        private int G;
        private int H;
        private Node father;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void init_node(Node father, Node end) {
            this.father = father;
            if (this.father != null) {
                this.G = father.G + 1;
            } else {
                this.G = 0;
            }
            this.H = Math.abs(this.x - end.x) + Math.abs(this.y - end.y);
            this.F = this.G + this.H;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.F, o.F);
        }
    }

}