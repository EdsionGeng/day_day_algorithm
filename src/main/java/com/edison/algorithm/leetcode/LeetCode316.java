package com.edison.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description TODO
 * @Date 2022/4/24下午12:23
 * @Created by edsiongeng
 */
public class LeetCode316 {
    //给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
//
//示例 1:
//
//输入: “bcabc”
//输出: “abc”
//示例 2:
//
//输入: “cbacdcbc”
//输出: “acdb”
//
//PS：
//我把每一个数出现的次数都拿出来，我当前字符比我栈顶的小，并且我栈顶的字符还有多的在后面，我就可以把他替换了，记录一下是否使用
//————————————————
//版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/a1439775520/article/details/104697732
    public String removeDuplicateLetters(String s) {
        int[] charsCount = new int[26];
        boolean[] visited = new boolean[26];
        int len = s.length();
        char[] sChars = s.toCharArray();
        for (char c : sChars) {
            charsCount[c - 'a']++;
        }
        Deque<Character> stack = new ArrayDeque<>();
        int index = 0;
        for (int count : charsCount) {
            if (count > 0) {
                index++;
            }
        }
        char[] res = new char[index];

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            while (!stack.isEmpty() && c < stack.peek() && charsCount[stack.peek() - 'a'] > 1
                    && !visited[c - 'a']) {
                Character pop = stack.pop();
                visited[pop - 'a'] = false;
                charsCount[pop - 'a']--;
            }
            if (visited[c - 'a']) {
                charsCount[c - 'a']--;
                continue;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        while (!stack.isEmpty()) {
            res[--index] = stack.pop();
        }
        return String.valueOf(res);
    }

    public String solution2(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a']--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode316 le = new LeetCode316();
        System.out.println(le.solution2("cbacdcbc"));

    }
}
