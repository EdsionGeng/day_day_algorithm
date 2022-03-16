package com.edison.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 描述:
 * 柱状图的最大矩形
 *
 * @author gengyc
 * @create 2022-01-19 14:04
 */
public class LeetCode84 {
    /**
     * 利用单调栈  求解，总体思路是 以柱子i高度为矩形高度时所能形成最大面积（利用性质找出第i个柱子向左边和右边遍历时第一个比它低的柱子）
     * 单调栈定义：只存高度递增的柱子
     * 性质
     * 出栈时：
     * 那么如果单调栈为空了：说明没有比这个柱子更低的了（矩形宽度为这根柱子的序号：左边沿为0）
     * 如果单调栈不为空：说明栈里面的柱子高度都小，那么左边沿为栈顶柱子的序号
     * <p>
     * 矩形右边沿为i 因为你出栈 就说明你比别人低了，这已经是你能达到的面积极限了.出栈记录面积
     **/
    public static int largestRectangleArea(int[] heights) {
        int heightn[] = new int[heights.length + 1];
        for (int i = 0; i < heights.length; i++) {
            heightn[i] = heights[i];
        }
        heightn[heights.length] = 0;
        Stack<Integer> stack = new Stack<>();
        int maxS = 0;
        for (int i = 0; i < heightn.length; i++) {
            while (!stack.isEmpty() && heightn[i] < heightn[stack.peek()]) {
                int temp = stack.pop();
                maxS = Math.max(maxS, ((stack.isEmpty() ? i : (i - stack.peek() - 1)) * (heights[temp])));
            }
            stack.push(i);
        }
        return maxS;
    }

    public static void main(String[] args) {
        largestRectangleArea(new int[]{2, 1, 5, 6, 3});
    }
}