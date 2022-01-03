package com.edison.algorithm.algorithm;

import java.util.*;

/**
 * 描述:
 * 最近公共祖先
 *
 * @author gengyc
 * @create 2021-12-07 19:10
 */
public class LCA {

    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }

    //1.递归解法
    public TreeNode getCommonNode(TreeNode head, TreeNode p1, TreeNode p2) {
        if (head == null) {
            return null;
        } else {
            if (head.val == p1.val && head.val == p2.val) {
                return head;
            }
            TreeNode n1 = getCommonNode(head.left, p1, p2);
            TreeNode n2 = getCommonNode(head.right, p1, p2);
            if (n1 != null && n2 != null) {
                return head;
            }
            return n1 == null ? n2 : n1;
        }
    }

    //2
    public TreeNode prePostOrderToCommonTreeNode(TreeNode head, TreeNode p1, TreeNode p2) {
        if(head == null || p1 == null || p2 == null){
            return null;
        }
        List<TreeNode> list1 = this.prePostOrderToList(head, p1);
        List<TreeNode> list2 = this.prePostOrderToList(head, p2);

        TreeNode node = null;
        for(int i = list1.size() - 1, j = list2.size() - 1; i >= 0 && j >= 0; i--, j--){
            if(list1.get(i) == list2.get(j)){
                //若两个值一样，则继续遍历，保存元素，若不一样，则说明node为公共祖先节点
                node = list1.get(i);
            }else{
                break;
            }
        }

        return node;
    }

    public List<TreeNode> prePostOrderToList(TreeNode head, TreeNode pNode){
        List<TreeNode> list = new ArrayList<>();
        if(head == null || pNode == null){
            return list;
        }
        Deque<TreeNode> s = new LinkedList<>();
        s.push(head);

        while(!s.isEmpty()){
            TreeNode p = s.peek();
            System.out.print(p.val + " ");
            if(pNode.val == p.val){
                break;
            }
            if(p.left != null){
                s.push(p.left);
            }else{
                while(p.right == null){
                    TreeNode last = s.pop();
                    //System.out.print(last.val + " ");

                    while(!s.isEmpty() && s.peek().right == last){
                        last = s.pop();
                        //System.out.print(last.val + " ");
                    }

                    if(s.isEmpty()){
                        break;
                    }
                    p = s.peek();
                }
                if(s.isEmpty()){
                    break;
                }else {
                    s.push(p.right);
                }
            }
        }
        Iterator<TreeNode> it = s.iterator();
        while(it.hasNext()){
            list.add(it.next());
        }

        return list;
    }


}