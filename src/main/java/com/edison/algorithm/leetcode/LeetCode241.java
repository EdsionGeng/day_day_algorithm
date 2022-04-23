package com.edison.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 运算表达式设计优先级
 * @Date 2022/4/7下午3:44
 * @Created by edsiongeng
 */
public class LeetCode241 {
    //给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
    //
    //示例 1:
    //
    //输入: “2-1-1”
    //输出: [0, 2]
    //解释:
    //((2-1)-1) = 0
    //(2-(1-1)) = 2
    //示例 2:
    //
    //输入: “23-45”
    //输出: [-34, -14, -10, -10, 10]
    //解释:
    //
    //(2*(3-(4*5))) = -34
    //((2*3)-(4*5)) = -14
    //((2*(3-4))*5) = -10
    //(2*((3-4)*5)) = -10
    //(((2*3)-4)*5) = 10
    //————————————————
    //版权声明：本文为CSDN博主「「违规用户」」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/a1439775520/article/details/104637439
    public Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) return map.get(input);
        List<Integer> list = new ArrayList<>();
        int len = input.length();
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                list.add(l + r);
                                break;
                            case '-':
                                list.add(l - r);
                                break;
                            case '*':
                                list.add(l * r);
                                break;

                        }
                    }
                }
            }

        }
        if (list.size() == 0) list.add(Integer.valueOf(input));
        map.put(input, list);
        return list;

    }

    public static void main(String[] args) {
        LeetCode241 le = new LeetCode241();
        System.out.println("abcd".substring(0,3));
        List<Integer> result = le.diffWaysToCompute("2*3-4*5");
        for (Integer i:result) {
            System.out.println(i);
        }
    }
}
