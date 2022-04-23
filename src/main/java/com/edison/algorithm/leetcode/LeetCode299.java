package com.edison.algorithm.leetcode;

/**
 * @Description TODO
 * @Date 2022/4/21下午12:10
 * @Created by edsiongeng
 */
public class LeetCode299 {

    public String getHint(String secret, String guess) {
        if (secret.length() == 0 || guess.length() == 0) {
            return "";
        }
        int i = 0, cnt = 0;
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        int[] sn = new int[10];
        int[] gn = new int[10];
        while (i < s.length && i < g.length) {
            if (s[i] == g[i]) {
                cnt++;
            } else {
                sn[s[i] - '0']++;
                gn[g[i] - '0']++;
            }
            i++;
        }
        i = 0;
        int cnt2 = 0;
        while (i < sn.length) {
            cnt2 += Math.min(sn[i], gn[i]);
            i++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append('A').append(cnt2).append('B');
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode299 le = new LeetCode299();
        System.out.println(le.getHint("1123", "0111"));
    }
}
