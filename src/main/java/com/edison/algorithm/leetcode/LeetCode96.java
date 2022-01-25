package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 不同的二叉搜索树
 *
 * @author gengyc
 * @create 2022-01-21 16:44
 */
public class LeetCode96 {

    //PS：输入: 3
    //输出: 5
    //解释:
    //给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
    //动态规划
    //
    //假设n个节点存在二叉排序树的个数是G(n)，令f(i)为以i为根的二叉搜索树的个数
    //
    //即有:G(n) = f(1) + f(2) + f(3) + f(4) + … + f(n)
    //
    //n为根节点，当i为根节点时，其左子树节点个数为[1,2,3,…,i-1]，右子树节点个数为[i+1,i+2,…n]，所以当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i，即f(i) = G(i-1)*G(n-i),
    //
    //上面两式可得:G(n) = G(0)G(n-1)+G(1)(n-2)+…+G(n-1)*G(0)
    //————————————————
    //版权声明：本文为CSDN博主「南     墙」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/a1439775520/article/details/104374028
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

}