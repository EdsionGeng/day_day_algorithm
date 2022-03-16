package com.edison.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * 检测链表是否有环
 *
 * @author gengyc
 * @create 2022-02-14 17:03
 */
public class LeetCode141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != head) {
            if (fast.next == null || fast.next.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode detectCycle2(ListNode head) {
        int pos = -1;
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode team = head;
        while (team != null) {
            if (map.containsKey(team)) {
                pos = map.get(team);
                return team;
            } else {
                map.put(team, ++pos);
            }
            team = team.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        boolean isloop = false;
        ListNode fast = new ListNode(0);
        ListNode slow = fast;
        fast.next = head;
        if (fast.next == null || fast.next.next == null) {
            return null;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isloop = true;
                break;
            }
        }
        if (!isloop) {
            return null;
        }
        ListNode team = new ListNode(-1);
        team.next = head;
        while (team != fast) {
            team = team.next;
            fast = fast.next;
        }
        return team;
    }

}