package com.edison.algorithm.leetcode;

//例如，上面的二叉树可以被序列化为字符串 “9,3,4,#,#,1,#,#,2,#,6,#,#”，其中 # 代表一个空节点。
//
//给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
//
//每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 ‘#’ 。
//
//你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 “1,3” 。
//
//示例 1:
//
//输入: “9,3,4,#,#,1,#,#,2,#,6,#,#”
//输出: true
//示例 2:
//
//输入: “1,#”
//输出: false
//示例 3:
//
//输入: “9,#,#,1”
//输出: false
//
//只要保证初度和入度相等即可，读一个不管是否为数字就应该-1，如果为数字就表示可以有两个孩子+2
//————————————————
//版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/a1439775520/article/details/104719205
public class LeetCode331 {

    public boolean isValidSerialization(String preorder) {
        String[] temp = preorder.split(",");
        if (temp[0].equals("#") && temp.length == 1) return true;
        if (temp[0].equals("#") || temp.length % 2 == 0) return false;
        int count = 1;
        for (int i = 0; i < temp.length; i++) {
            count--;
            if (count < 0) return false;
            if (!temp[i].equals("#")) {
                count += 2;
            }
        }
        return count == 0;

    }
}
