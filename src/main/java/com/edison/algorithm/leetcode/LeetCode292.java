package com.edison.algorithm.leetcode;

/**
 * @Description Nim游戏
 * @Date 2022/4/17下午3:58
 * @Created by edsiongeng
 */
public class LeetCode292 {
    //你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
    //
    //你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
    //
    //示例:
    //
    //输入: 4
    //输出: false
    //解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
    //因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
    //
    //巴什博奕，n%(m+1)!=0时，先手总是会赢的
    //
    //
    //————————————————
    //版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/a1439775520/article/details/104676280
    public boolean nim(int num){
        return !(num%4==0);
    }
}
