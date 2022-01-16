package com.edison.algorithm.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 描述:
 * 插入区间
 *
 * @author gengyc
 * @create 2022-01-14 13:20
 */
public class LeetCode57 {
    //给出一个无重叠的 ，按照区间起始端点排序的区间列表。
    //
    //在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
    //
    //示例 1:
    //
    //输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
    //输出: [[1,5],[6,9]]
    //示例 2:
    //
    //输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
    //输出: [[1,2],[3,10],[12,16]]
    //解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length + 1][];
        System.arraycopy(intervals, 0, newIntervals, 0, intervals.length);
        newIntervals[intervals.length] = newInterval;

        Arrays.sort(newIntervals, (a, b) -> a[0] - b[0]);
        Stack<int[]> stack = new Stack<>();
        for (int[] num : newIntervals) {
            if (stack.isEmpty()) {
                stack.push(num);
                continue;
            }
            int[] arr = stack.peek();
            if (arr[1] >= num[0]) {
                int[] combine = {arr[0], Math.max(arr[1], num[1])};
                stack.pop();
                stack.push(combine);
            } else {
                stack.push(num);
            }
        }
        return stack.toArray(new int[0][]);
    }

    public static void main(String[] args) {

    }

}