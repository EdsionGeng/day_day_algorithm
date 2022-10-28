package com.edison.algorithm.offer;


//二叉搜索树 与双向链表
public class Offer36 {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left,Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

  Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;//进行头结点和尾节点相互指向，顺序可以互换
        return head;
    }

    public void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);

        if (pre != null) {
            //pre!=null cur 左侧存在节点pre，需要进行pre.right=cur操作
            pre.right = cur;
        } else {
            //pre用于记录双向链表位于cur左侧节点。即上一次迭代的cur.当pre==null cur左侧没有节点，此时cur为双向链表的头结点
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
