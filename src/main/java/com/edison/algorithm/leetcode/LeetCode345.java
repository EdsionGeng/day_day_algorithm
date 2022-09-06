package com.edison.algorithm.leetcode;


/**
 * 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: “hello”
 * 输出: “holle”
 * 示例 2:
 * <p>
 * 输入: “leetcode”
 * 输出: “leotcede”
 * 说明:
 * 元音字母不包含字母"y"。
 */
public class LeetCode345 {

    public void reverse(char[] ss) {
        int i = 0, j = ss.length - 1;
        while (i < j) {
            while (i < j && (ss[j] != 'a' && ss[j] != 'e' && ss[j] != 'i' && ss[j] != 'o' && ss[j] != 'u' && ss[j] != 'A' && ss[j] != 'E' && ss[j] != 'I' && ss[j] != 'O' && ss[j] != 'U')) {
                j--;
            }
            while (i < j && (ss[i] != 'a' && ss[i] != 'e' && ss[i] != 'i' && ss[i] != 'o' && ss[i] != 'u' && ss[i] != 'A' && ss[i] != 'E' && ss[i] != 'I' && ss[i] != 'O' && ss[i] != 'U')) {
                i++;
            }
            if (ss[i] != ss[j]) {
                ss[i] ^= ss[j];
                ss[j] ^= ss[i];
                ss[i] ^= ss[j];
            }
            i++;
            j--;
        }
        for (char s : ss) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        LeetCode345 le = new LeetCode345();
        le.reverse(new char[]{'h', 'e', 'l', 'l', 'o'});
    }
}
