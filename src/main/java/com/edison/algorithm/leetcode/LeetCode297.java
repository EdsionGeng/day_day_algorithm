package com.edison.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @Description 二叉树序列化和反序列化
 * @Date 2022/4/17下午5:02
 * @Created by edsiongeng
 */
public class LeetCode297 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String serialize(TreeNode root) {
        StringBuilder res = serHelp(root, new StringBuilder());
        return res.toString();
    }

    public StringBuilder serHelp(TreeNode root, StringBuilder str) {
        if (null == root) {
            str.append("null,");
            return str;
        }
        str.append(root.val);
        str.append(",");
        str = serHelp(root.left, str);
        str = serHelp(root.right, str);
        return str;
    }

    public TreeNode deserialize(String str) {
        String[] str_word = str.split(",");

        List<String> list = Arrays.asList(str_word);
        return deserHelp(list);

    }

    public TreeNode deserHelp(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = deserHelp(list);
        root.right = deserHelp(list);
        return root;

    }

}
