package com.algorithmic.other.lintcode;

import java.util.List;

/**
 * 链表翻转II
 */
public class Alg36 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
       ListNode dummy = new ListNode(0);
       dummy.next = head;

       ListNode mPre = null;
       ListNode pre = dummy;
       ListNode cur = head;
       for(int i = 1; i <= m; i++){
           mPre = pre;
           pre = pre.next;
           cur = cur.next;
       }

       for(int i = m + 1; i <= n; i++){
           ListNode next = cur.next;
           cur.next = pre;
           pre = cur;
           cur = next;
       }
       mPre.next.next = cur;
       mPre.next = pre;
       return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
