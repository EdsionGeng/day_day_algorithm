package com.edison.algorithm.leetcode;


import java.util.PriorityQueue;

/**
 * @Description TODO
 * @Date 2022/5/13下午3:56
 * @Created by edsiongeng
 */
public class LeetCode313 {
    //313. 超级丑数
    //编写一段程序来查找第 n 个超级丑数。
    //
    //超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
    //
    //示例:
    //
    //输入: n = 12, primes = [2,7,13,19]
    //输出: 32
    //解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
    //说明:
    //
    //1 是任何给定 primes 的超级丑数。
    //给定 primes 中的数字以升序排列。
    //0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
    //第 n 个超级丑数确保在 32 位有符整数范围内。
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> q = new PriorityQueue();
        q.add(1);
        while (n-- > 0) {
            int x = q.poll();
            if (n == 0) return x;
            for (int k : primes) {
                if (k <= Integer.MAX_VALUE / x) q.add(k * x);
                if (x % k == 0) break;
            }
        }
        return -1;
    }
}
