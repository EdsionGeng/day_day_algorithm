package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 删除无效符号
 * @Date 2022/4/18下午11:43
 * @Created by edsiongeng
 */
public class LeetCode301 {
    //删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
    //
    //说明: 输入可能包含了除 ( 和 ) 以外的字符。
    //
    //示例 1:
    //
    //输入: “()())()”
    //输出: ["()()()", “(())()”]
    //示例 2:
    //
    //输入: “(a)())()”
    //输出: ["(a)()()", “(a())()”]
    //示例 3:
    //
    //输入: “)(”
    //输出: [""]
    //————————————————
    //版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/a1439775520/article/details/104680038

    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left == 0) right++;
                else left--;
            }
        }
        List<String> res = new ArrayList<>();
        backtrace(cs, 0, new StringBuilder(s.length() - left - right), res, 0, 0, left, right);

        return res;
    }

    private void backtrace(char[] cs, int cur, StringBuilder sb, List<String> res,
                           int left, int right, int remL, int remR) {
        if (cur == cs.length) {
            if (remL == 0 && remR == 0) res.add(sb.toString());
            return;
        }
        if (right > left) return;
        final int len = sb.length();
        if (cs[cur] == '(') {
            sb.append('(');
            backtrace(cs, cur + 1, sb, res, left + 1, right, remL, remR);
            sb.setLength(len);
            if (remL > 0) {
                while (cur < cs.length && cs[cur] == '(') {
                    cur++;
                    remL--;
                }
                if (remL >= 0) backtrace(cs, cur, sb, res, left, right, remL, remR);
            }
        } else if (cs[cur] == ')') {
            sb.append(')');
            backtrace(cs, cur + 1, sb, res, left, right + 1, remL, remR);
            sb.setLength(len);
            if (remR > 0) {
                while (cur < cs.length && cs[cur] == ')') {
                    cur++;
                    remR--;
                }
                if (remR >= 0) backtrace(cs, cur, sb, res, left, right, remL, remR);
            }
        } else {
            sb.append(cs[cur]);
            backtrace(cs, cur + 1, sb, res, left, right, remL, remR);
            sb.setLength(len);
        }

    }

    public static void main(String[] args) {
        LeetCode301 le = new LeetCode301();
        List<String> result = le.removeInvalidParentheses("(a)())()");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
