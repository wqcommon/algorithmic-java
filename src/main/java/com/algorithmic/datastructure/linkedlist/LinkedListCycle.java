package com.algorithmic.datastructure.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiang.wen
 * @date 2018/8/28 20:39
 *
 * 判断链表是否有环
 *
 * 描述：给定一个链表，判断它是否有环。
 *
 * 例如：给出 -21->10->4->5, tail connects to node index 1，返回 true
 *
 * 挑战：不要使用额外的空间
 */
public class LinkedListCycle {

    public static void main(String[] args) {

    }


    /**
     * 借用了一个Map作为额外的空间来进行处理
     * 另外性能也不高
     * 综合评价：性能不高
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        // write your code here
        if(head == null){
            return false;
        }
        Map<ListNode,Integer> countMap = new HashMap<>();
        while (head != null){
            Integer count = countMap.get(head);
            if(count != null && count > 0){
                return true;
            }else {
                countMap.put(head,1);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 通过两个指针来处理，快慢指针，只要有环，就快的指针一定能再次遇到慢的指针
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        // write your code here
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow){
           if(fast == null || fast.next == null){
               return false;
           }
           fast = fast.next.next;
           slow = slow.next;
        }
        return true;
    }

    private class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }
}
