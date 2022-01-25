package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 扰乱字符串
 *
 * @author gengyc
 * @create 2022-01-20 10:19
 */
public class LeetCode87 {
    //给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
    //
    //示例 1:
    //
    //输入: s1 = “great”, s2 = “rgeat”
    //输出: true
    //示例 2:
    //
    //输入: s1 = “abcde”, s2 = “caebd”
    //输出: false
    public boolean isScramble(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) return true;
        if (s1.length() != s2.length()) return false;
        return dfs(s1.toCharArray(), s2.toCharArray(), 0, 0, s1.length());
    }

    private boolean dfs(char[] s1, char[] s2, int start1, int start2, int len) {
        if (len == 1) {
            return s1[start1] == s2[start2];
        }
        if (!equals(s1, s2, start1, start2, len)) {
            return false;
        }
        for (int i = 1; i < len; i++) {
            //两个字符串是否相等                    我的搜索位置往后走i，我的结束就要往前走i防止超限
            if (dfs(s1, s2, start1, start2, i) && dfs(s1, s2, start1 + i, start2 + i, len - i)) return true;
            //  |i到len-1|这块进行翻转
            if (dfs(s1, s2, start1, start2 + len - i, i) && dfs(s1, s2, start1 + i, start2, len - i)) return true;
        }
        return false;
    }

    public boolean equals(char[] s1, char[] s2, int start1, int start2, int len) {
        int[] charArr = new int[26];
        for (int i = 0; i < len; i++) {
            charArr[s1[start1 + i] - 'a']++;
            charArr[s2[start2 + i] - 'a']--;
        }
        for (int item : charArr) {
            if (item != 0) return false;
        }
        return true;
    }

    //DFS剪枝版本AC
    public boolean isScrambleAC(String s1, String s2) {
        int[] A = new int[128];
        int len = s1.length();
        if (len <= 1) {
            return s1 == s2;
        }
        for (char c : s1.toCharArray()) {
            A[c]++;
        }
        for (char c : s2.toCharArray()) {
            A[c]--;
        }
        for (int i = 0; i < 128; i++) {
            if (A[i] != 0) {
                return false;
            }
        }
        for (int i = 1; i < len; i++) {
               //s1前i对s2前i
            if (isScrambleAC(s1.substring(0, i), s2.substring(0, i)) &&
                    //且 s1后len-i对s2后len-i
                    isScrambleAC(s1.substring(i, len), s2.substring(i, len))
                    //下面是该节点两个子树交换的效果，由前对前后对后，变为前后后前。
                    //或 s1前i对s2后i
                    || isScrambleAC(s1.substring(0, i), s2.substring(len - i, i))&&
                    //且 s1后len-i对s2前len-i
                    isScrambleAC(s1.substring(i, len), s2.substring(0, len - i)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode87 leetCode87 = new LeetCode87();
        System.out.println(leetCode87.isScramble("great", "rgeat"));

    }
}