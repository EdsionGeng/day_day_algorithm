package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
//
//示例：
//
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
//提示：
//
//S的长度在[1, 500]之间。
//
//S只包含小写字母 'a' 到 'z' 。
//
//Related Topics
//
//贪心
//
//哈希表
//
//双指针字符串
//————————————————
//版权声明：本文为CSDN博主「Yingmu__」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/yingmu__/article/details/122773186
public class LeetCode763 {
    public List<Integer> partitionLabels(String s) {
        int[] index = new int[26];
        ArrayList<Integer> list = new ArrayList<>();
        int length = s.length();
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, index[s.charAt(i) - 'a']);
            if (i == end) {
                list.add(end - start + 1);
                end++;
                start = end;
            }

        }
        return list;

    }
}
