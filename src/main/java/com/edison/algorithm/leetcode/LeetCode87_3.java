package com.edison.algorithm.leetcode;

/**
 * 描述:
 * dfs剪枝+记忆化递归+哈希+质因数分解
 *
 * @author gengyc
 * @create 2022-01-20 14:36
 */
public class LeetCode87_3 {
    static int[] hash_table = {163, 191, 223, 241, 271, 307, 337, 367, 397, 431, 457, 487, 521, 563, 593, 617, 647, 677, 719, 751, 787, 823, 857, 883, 929, 967};

    public boolean isScramble(String s1, String s2) {
        if(s1==null&&s2!=null||s2==null&&s1!=null||s1.length()!=s2.length()) return false;
        boolean[][][] dp=new boolean[s1.length()][s2.length()][s1.length()+1];
        //初始化len=1
        for (int i = 0; i < s1.length(); i++) {//第一个字符串的起点
            for (int j = 0; j < s2.length(); j++) {//第二个字符串的起点
                if(s1.charAt(i)==s2.charAt(j)) dp[i][j][1]=true;
            }
        }
        for (int len = 2; len <=s1.length(); len++) {//区间长度
            for (int i = 0; i < s1.length(); i++) {//第一个字符串的起点,终点i+len-1
                for (int j = 0; j < s2.length(); j++) {//第二个字符串的起点,终点j+len-1
                    for (int k = 1; k <len; k++) {//左边区间的长度，因为要划分成两个区间，所以左边那个区间的长度是1...len-1（至少为一，至多也得给第二个区间留一个）
                        if(i+k<s1.length()&&j+k<s1.length()&&j+len-k<s1.length()&&((dp[i][j][k]&&dp[i+k][j+k][len-k])||(dp[i][j+len-k][k]&&dp[i+k][j][len-k]))){
                            dp[i][j][len]=true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][s1.length()];
    }
}