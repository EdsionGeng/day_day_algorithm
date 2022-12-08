package com.edison.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

public class 课程表2 {
    //存储有向图
    List<List<Integer>> edges;
    //0未搜索 1搜索中 2已完成
    int[] visited;
    //数组模拟栈 n-1为栈底 0为栈顶
    int[] result;
    //判断有向图中是否有环
    boolean valid=true;
    //栈下标
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;

        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }

        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if (!valid) {
            return new int[0];
        }
        return result;

    }

    public void dfs(int u) {
        //节点标记为搜索中
        visited[u] = 1;
        //搜索相邻节点  发现有环 立刻停止搜索
        for (int v : edges.get(u)) {
            //如果未搜索，那么搜索相邻节点
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        //将节点标记为已完成
        visited[u] = 2;
        //将节点入栈
        result[index--] = u;
    }

    public static void main(String[] args) {
        课程表2 le = new 课程表2();
        int[] result = le.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        for (int i : result) {
            System.out.println(i);
        }
    }
}
