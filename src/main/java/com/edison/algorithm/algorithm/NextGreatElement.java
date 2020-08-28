package com.edison.algorithm.algorithm;


import java.util.Stack;

/**
 * @Description 单调栈
 * @Date 2020/8/26下午11:12
 * @Created by edsiongeng
 */
public class NextGreatElement {

    /**
     * 给你一个数组 [2,1,2,4,3]，你返回数组 [4,2,4,-1,-1]。
     * <p>
     * 解释：第一个 2 后面比 2 大的数是 4; 1 后面比 1 大的数是 2；
     * 第二个 2 后面比 2 大的数是 4; 4 后面没有比 4 大的数，填 -1；
     * 3 后面没有比 3 大的数，填 -1。
     */


    public static int[] nextGreatElement(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 4, 3};
        int[] result = nextGreatElement(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
