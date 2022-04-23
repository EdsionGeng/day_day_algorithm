package com.edison.algorithm.leetcode;

/**
 * @Description 有效字母异位词
 * @Date 2022/4/7下午4:28
 * @Created by edsiongeng
 */
public class LeetCode242 {
    //给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    //
    //示例 1:
    //
    //输入: s = “anagram”, t = “nagaram”
    //输出: true
    //示例 2:
    //
    //输入: s = “rat”, t = “car”
    //输出: false
    //说明:
    //你可以假设字符串只包含小写字母。
    //————————————————
    //版权声明：本文为CSDN博主「「违规用户」」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/a1439775520/article/details/104641356
    public boolean isAnagram(String s, String t) {
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;

        }
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]--;

        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                return false;
            }

        }
        return true;
    }
}
