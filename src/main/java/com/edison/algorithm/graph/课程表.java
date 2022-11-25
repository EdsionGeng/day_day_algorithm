package com.edison.algorithm.graph;

import java.util.*;

public class 课程表 {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if (len == 0) return true;

        int[] count = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            count[prerequisites[i][1]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (count[i] == 0) {
                stack.push(i);
            }
        }
        int m = 0, result = 0;
        while (!stack.isEmpty()) {
            m = stack.pop();
            result++;
            for (int i = 0; i < len; i++) {
                if (prerequisites[i][0] == m) {
                    count[prerequisites[i][1]]--;
                    if (count[prerequisites[i][1]] == 0) {
                        stack.push(prerequisites[i][1]);
                    }
                }

            }
        }
        return result == numCourses;

    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0},{0,1}}));
    }
}
