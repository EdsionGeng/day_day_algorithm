package com.edison.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

//最多K次交换相邻位数得到最小整数
public class LeetCode1505 {
    static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        public static int lowbit(int x) {
            return x & (-x);
        }

        public void update(int x) {
            while (x <= n) {
                ++tree[x];
                x += lowbit(x);
            }
        }

        public int query(int x) {
            int ans = 0;
            while (x > 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
        }

        public int query(int x, int y) {
            return query(y) - query(x - 1);
        }
    }

    public String minInteger(String num, int k) {
        int n = num.length();
        Queue<Integer>[] pos = new Queue[10];
        for (int i = 0; i < 10; i++) {
            pos[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            pos[num.charAt(i) - '0'].offer(i + 1);
        }

        StringBuffer ans = new StringBuffer();
        BIT bit = new BIT(n);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (!pos[j].isEmpty()) {
                    int behind = bit.query(pos[j].peek() + 1, n);
                    int dist = pos[j].peek() + behind - i;
                    if (dist <= k) {
                        bit.update(pos[j].poll());
                        ans.append(j);
                        k -= dist;
                        break;
                    }
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        LeetCode1505 le = new LeetCode1505();
        System.out.println(le.minInteger("4321",4));
    }
}
