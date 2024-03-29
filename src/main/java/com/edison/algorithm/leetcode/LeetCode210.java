package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 描述:
 * 课程表2
 *
 * @author gengyc
 * @create 2022-03-08 19:28
 */
public class LeetCode210 {
    //现在你总共有 n 门课需要选，记为 0 到 n-1。
//
//在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
//
//给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
//
//可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
//
//示例 1:
//
//输入: 2, [[1,0]]
//输出: [0,1]
//解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
//示例 2:
//
//输入: 4, [[1,0],[2,0],[3,1],[3,2]]
//输出: [0,1,2,3] or [0,2,1,3]
//解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
//说明:
//
//输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
//你可以假定输入的先决条件中没有重复的边。
//提示:
//
//这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
//通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
//拓扑排序也可以通过 BFS 完成。
//————————————————
//版权声明：本文为CSDN博主「南     墙」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/a1439775520/article/details/104519278
    public int[] findOrder(int numCourses, int[][] prerequisties) {
        int[] results = new int[numCourses];
        int[] degree = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisties.length; i++) {
            degree[prerequisties[i][0]]++;
            edges.get(prerequisties[i][1]).add(prerequisties[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        //入度为0放在队列中
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                ((LinkedList<Integer>) queue).add(i);
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            results[index++] = course;
            count++;
            for (Integer c : edges.get(course)) {
                degree[c]--;
                if (degree[c] == 0) {
                    ((LinkedList<Integer>) queue).add(c);
                }
            }
        }
        if (count != numCourses) {
            return new int[0];
        }
        return results;
    }

    public static void main(String[] args) {
        LeetCode210 le = new LeetCode210();
        int[] result = le.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}