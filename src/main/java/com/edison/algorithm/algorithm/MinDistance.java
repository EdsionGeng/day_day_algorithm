package com.edison.algorithm.algorithm;

import java.util.LinkedList;


/**
 * @Description 最短路径 广度优先搜索实现
 * @Date 2020/7/16下午11:05
 * @Created by edsiongeng
 */
public class MinDistance {

    /**
     * 重要组成方向，上下左右
     */
    int[][] direct = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int[][] array = {{0, 0, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 1, 0}};

    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        minDistance.BFS();
    }


    public void BFS() {
        Node start = new Node(0, 0, 0, null);
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(start);


        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int row_temp = temp.row + direct[i][0];
                int column_temp = temp.column + direct[i][1];
                if (row_temp < 0 || column_temp < 0 || row_temp >= 4 || column_temp >= 4) {
                    continue;
                }
                if (array[row_temp][column_temp]==1) {
                    continue;
                }
                Node next = new Node(row_temp, column_temp, temp.round + 1, temp);

                if (row_temp == 3 && column_temp == 3) {
                    queue.clear();
                    queue.offerFirst(next);

                    while (next.pre != null) {
                        queue.addFirst(next.pre);
                        next = next.pre;
                    }

                    for (Node node : queue) {
                        System.out.println("row:" + node.row + " column:" + node.column);
                    }
                }

                array[row_temp][column_temp] = 1;
                queue.offer(next);
            }
        }

//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//
//                System.out.println(array[i][j]);
//
//            }
//
//        }
    }


    class Node {
        int row;
        int column;
        int round;
        Node pre;

        Node(int row, int column, int round, Node pre) {
            this.row = row;
            this.column = column;
            this.round = round;
            this.pre = pre;
        }
    }
}
