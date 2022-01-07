package com.edison.algorithm.leetcode;

/**
 * 描述:
 * 外观数列
 *
 * @author gengyc
 * @create 2022-01-06 13:48
 */
public class LeetCode38 {

    /**
     * 1
     * 11
     * 21
     * 1211
     * 111221
     * 1 被读作 “one 1” (“一个一”) , 即 11。
     * 11 被读作 “two 1s” (“两个一”）, 即 21。
     * 21 被读作 “one 2”, “one 1” （“一个二” , “一个一”) , 即 1211。
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String pre = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            char c = pre.charAt(0);
            int cnt = 1;
            for (int j = 1; j < pre.length(); j++) {
                char cc = pre.charAt(j);
                if (c == cc) {
                    cnt++;
                } else {
                    temp.append(cnt).append(c);
                    cnt = 1;
                    c = cc;
                }
            }
            temp.append(cnt).append(c);
            pre = temp.toString();
        }
        return pre;
    }

    public static void main(String[] args) {
        LeetCode38 leetCode38 = new LeetCode38();
        System.out.println(leetCode38.countAndSay(6));
    }
}