package com.edison.algorithm.offer;

import java.util.HashMap;
import java.util.Map;

//复杂链表的复制
public class Offer35 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Map<Node, Node> cacheNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (!cacheNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cacheNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cacheNode.get(head);
    }

//   public Node copyRandomList2(Node head) {
//        if (head == null) return null;
//        for (Node node = head; node != null; node = node.next.next) {
//
//        }
//
//
//        return headNew;
//    }
}
