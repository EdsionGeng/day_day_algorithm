package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 跳跃游戏
 *
 * @author gengyc
 * @create 2022-01-10 16:41
 */
public class LeetCode45 {
    //给定一个非负整数数组，你最初位于数组的第一个位置。
    //
    //数组中的每个元素代表你在该位置可以跳跃的最大长度。
    //
    //你的目标是使用最少的跳跃次数到达数组的最后一个位置。
    //
    //示例:
    //
    //输入: [2,1,2,1,4]
    //输出: 2
    //解释: 跳到最后一个位置的最小跳跃数是 2。
    //从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
    //说明:
    //
    //假设你总是可以到达数组的最后一个位置。
    //
    //PS：
    //鉴于题目已经给了前提，那就是肯定能到达最后一个元素，那么只要考虑每一跳所能达到的最远位置就行了，也就是每次都选择最远可达的点，reach是当前需要进行跳跃的右界限，nextReach是下一次跳跃的右界限，nextReach的值一直动态更新，以保证每次跳跃都是最远的


    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int reach = 0, nextreach = nums[0], step = 0;
        for (int i = 0; i < nums.length; i++) {
            nextreach = Math.max(i + nums[i], nextreach);
            if (nextreach >= nums.length - 1) {
                return step + 1;
            }
            if (reach == i) {
                step++;
                reach = nextreach;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        LeetCode45 leetCode45 = new LeetCode45();
        System.out.println(leetCode45.jump(new int[]{1, 1, 2, 1, 4}));
    }

}