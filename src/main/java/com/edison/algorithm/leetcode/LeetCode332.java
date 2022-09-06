package com.edison.algorithm.leetcode;


import java.util.*;

//332. 重新安排行程
//给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
//
//说明:
//
//如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 [“JFK”, “LGA”] 与 [“JFK”, “LGB”] 相比就更小，排序更靠前
//所有的机场都用三个大写字母表示（机场代码）。
//假定所有机票至少存在一种合理的行程。
//示例 1:
//
//输入: [[“MUC”, “LHR”], [“JFK”, “MUC”], [“SFO”, “SJC”], [“LHR”, “SFO”]]
//输出: [“JFK”, “MUC”, “LHR”, “SFO”, “SJC”]
//示例 2:
//
//输入: [[“JFK”,“SFO”],[“JFK”,“ATL”],[“SFO”,“ATL”],[“ATL”,“JFK”],[“ATL”,“SFO”]]
//输出: [“JFK”,“ATL”,“JFK”,“SFO”,“ATL”,“SFO”]
//解释: 另一种有效的行程是 [“JFK”,“SFO”,“ATL”,“JFK”,“ATL”,“SFO”]。但是它自然排序更大更靠后。
//————————————————
//版权声明：本文为CSDN博主「普通网友」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/a1439775520/article/details/104719500
public class LeetCode332 {
    private Map<String, PriorityQueue<String>> map = new HashMap<>();
    private List<String> resList = new LinkedList<>();

    public List<String> findItlineary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            if (!map.containsKey(src)) {
                PriorityQueue<String> pq = new PriorityQueue<>();
                map.put(src, pq);
            }
            map.get(src).add(dst);
        }
        dfs("JFK");
        return resList;
    }


    private void dfs(String src) {
        PriorityQueue<String> pc = map.get(src);
        while (pc != null && !pc.isEmpty()) {
            dfs(pc.poll());
        }
        ((LinkedList) resList).addFirst(src);

    }

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();

        List<String> list1 = new ArrayList<>();
        list1.add("JFK");
        list1.add("SFO");
        List<String> list2 = new ArrayList<>();
        list2.add("JFK");
        list2.add("ATL");
        List<String> list3 = new ArrayList<>();
        list3.add("SFO");
        list3.add("ATL");
        List<String> list4 = new ArrayList<>();
        list4.add("ATL");
        list4.add("JFK");
        List<String> list5 = new ArrayList<>();
        list5.add("ATL");
        list5.add("SFO");
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);
        LeetCode332 le = new LeetCode332();
        le.findItlineary(list);

        for (String str: le.resList
             ) {
            System.out.print(str+" ->");
        }
    }
}
