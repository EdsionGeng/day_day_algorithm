package com.edison.algorithm.algorithm;

import org.w3c.dom.NamedNodeMap;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 描述:
 * 对称迷宫搜索
 *
 * @author gengyc
 * @create 2021-12-14 11:22
 */
public class DoubleBFS {
    static class Node {
        int x;
        int y;
        String path = "";

        public Node() {
        }

        public Node(int x, int y, String team) {
            this.x = x;
            this.y = y;
            this.path = team;
        }
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        int n = 7;
//        String map[][] = {{"A","A2","A3","A4","A5","A6","A7"},
//                {"B1","B2","B3","B4","B5","B6","B7"},
//                {"C1","C2","C3","C4","C5","C6","C7"},
//                {"D1","D2","D3","D4","D5","D6","D7"},
//                {"E1","E2","E3","E4","E5","E6","E7"},
//                {"F1","F2","F3","F4","F5","F6","F7"},
//                {"G1","G2","G3","G4","G5","G6","G7"}};
        String map[][] = {{"A", "A", "A", "A", "A", "A", "A"},
                {"B", "B", "B", "B", "B", "B", "B"},
                {"C", "C", "C", "C", "C", "C", "C"},
                {"D", "D", "D", "D", "D", "D", "D"},
                {"E", "E", "E", "E", "E", "E", "E"},
                {"F", "F", "F", "F", "F", "F", "F"},
                {"G", "G", "G", "G", "G", "G", "G"}};
        Queue<Node> q1 = new ArrayDeque<>();//坐上队列
        Queue<Node> q2 = new ArrayDeque<>();//右下队列
        for (int i = 0; i < n; i++) {
            q1.clear();
            q2.clear();
            Set<String> set1 = new HashSet<>();
            Set<String> set2 = new HashSet<>();
            q1.add(new Node(i, n - i - 1, "" + map[i][n - i - 1]));
            q2.add(new Node(i, n - i - 1, "" + map[i][n - i - 1]));
            while (!q1.isEmpty() && !q2.isEmpty()) {
                Node team = q1.poll();
                Node team2 = q2.poll();
                if (team.x == n - 1 && team.y == n - 1) {
                    set1.add(team.path);
                    set2.add(team2.path);
                } else {
                    if (team.x < n - 1) {
                        q1.add(new Node(team.x + 1, team.y, team.path + map[team.x + 1][team.y]));
                    }
                    if (team.y < n - 1) {
                        q1.add(new Node(team.x, team.y + 1, team.path + map[team.x][team.y + 1]));
                    }
                    if (team2.x > 0) {
                        q2.add(new Node(team2.x - 1, team2.y, team2.path + map[team2.x - 1][team2.y]));
                    }
                    if (team2.y > 0) {
                        q2.add(new Node(team2.x, team2.y - 1, team2.path + map[team2.x][team2.y - 1]));
                    }
                }
            }
            for (String va : set1) {
                if (set2.contains(va)) {
                    set.add(va);
                }
            }
        }
        System.out.println(set.size());
    }
}